package net.dixton.model.skin;

import jakarta.persistence.Embeddable;

@Embeddable
public record SkinData(String texture, String signature) {}
