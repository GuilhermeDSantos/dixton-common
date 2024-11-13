package net.dixton.exceptions.server;

public class ServerNotFoundException extends RuntimeException {
    public ServerNotFoundException(Long id) {
        super("Server not found with id: " + id);
    }
}
