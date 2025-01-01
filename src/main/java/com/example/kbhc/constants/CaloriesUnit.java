package com.example.kbhc.constants;

import java.util.Arrays;

public enum CaloriesUnit {
    KCAL("kcal");

    private String unit;

    CaloriesUnit(String unit) {
        this.unit = unit;
    }

    public static CaloriesUnit getByUnit(String unit) {
        return Arrays.stream(CaloriesUnit.values())
                .filter(caloriesUnit -> caloriesUnit.unit.equals(unit))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Calories Unit Not Found"));
    }
}
