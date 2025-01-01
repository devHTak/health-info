package com.example.kbhc.constants;

import java.util.Arrays;

public enum DistanceUnit {
    KM("km");

    private String unit;

    DistanceUnit(String unit) {
        this.unit = unit;
    }

    public static DistanceUnit getByUnit(String unit) {
        return Arrays.stream(DistanceUnit.values())
                .filter(distanceUnit -> distanceUnit.unit.equals(unit))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Distance Unit Not Found"));
    }
}
