package net.dixton.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record SkinData(String texture, String signature) {}
