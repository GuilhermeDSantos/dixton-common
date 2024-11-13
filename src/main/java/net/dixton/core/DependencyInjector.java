package net.dixton.core;

import net.dixton.annotations.Injectable;
import net.dixton.annotations.PostConstruct;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Responsible for managing dependency injection and initializing @PostConstruct methods in order.
 */
public class DependencyInjector {

    private static DependencyInjector instance;
    private final Map<Class<?>, Object> instances;

    private DependencyInjector() {
        instances = new HashMap<>();
    }

    public static DependencyInjector getInstance() {
        if (instance == null) {
            instance = new DependencyInjector();
        }
        return instance;
    }

    /**
     * Scans a package and loads all @Injectable classes.
     * @param packageName The package to scan
     */
    public void loadInjectables(String packageName) throws Exception {
        // Discover all classes annotated with @Injectable in the given package
        Set<Class<?>> injectableClasses = findClassesWithAnnotation(packageName);
        for (Class<?> clazz : injectableClasses) {
            getInstance(clazz); // Ensure all @Injectable classes are instantiated
        }
    }

    /**
     * Retrieves an instance of a class, creating and injecting dependencies if needed.
     * @param clazz The class to instantiate
     * @return The instance with injected dependencies
     */
    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (!clazz.isAnnotationPresent(Injectable.class)) {
            throw new IllegalArgumentException("Class " + clazz.getName() + " is not marked as @Injectable.");
        }

        // Check if instance already exists
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        // Create and store the instance
        T instance = createInstance(clazz);
        instances.put(clazz, instance);
        return instance;
    }

    private <T> T createInstance(Class<T> clazz) throws Exception {
        // Ensure there's a no-args constructor
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T instance = constructor.newInstance();

        // Inject dependencies
        injectDependencies(instance);

        // Call @PostConstruct methods in order of priority
        invokePostConstructMethods(instance);

        return instance;
    }

    private void injectDependencies(Object instance) throws Exception {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Injectable.class)) {
                field.setAccessible(true);
                Object dependency = getInstance(field.getType()); // Recursively get or create the dependency
                field.set(instance, dependency);
            }
        }
    }

    private void invokePostConstructMethods(Object instance) throws Exception {
        // Find methods annotated with @PostConstruct
        Method[] methods = Arrays.stream(instance.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(PostConstruct.class))
                .toArray(Method[]::new);

        // Sort methods by priority (higher values first)
        Arrays.sort(methods, Comparator.comparingInt(
                method -> -method.getAnnotation(PostConstruct.class).priority()));

        // Invoke each method in sorted order
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(instance);
        }
    }

    private Set<Class<?>> findClassesWithAnnotation(String packageName) {
        // Use Reflections to scan for classes annotated with @Injectable
        Reflections reflections = new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(Injectable.class);
    }
}
