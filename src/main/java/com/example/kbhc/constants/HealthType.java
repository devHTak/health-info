package com.example.kbhc.constants;

import java.util.Arrays;

public enum HealthType {
    STEPS("steps");

    private String type;

    HealthType(String type) {
        this.type = type;
    }

    public static HealthType getByType(String type) {
        return Arrays.stream(HealthType.values())
                .filter(healthType -> healthType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Health Type Not Found"));
    }
}
