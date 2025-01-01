package com.example.kbhc.usecase.dto;

import java.math.BigDecimal;

public class HealthSummaryDto {
    private String period;
    private BigDecimal steps;
    private BigDecimal distance;
    private BigDecimal calories;
    private String recordkey;

    public HealthSummaryDto(String period, BigDecimal steps, BigDecimal distance, BigDecimal calories, String recordkey) {
        this.period = period;
        this.steps = steps;
        this.distance = distance;
        this.calories = calories;
        this.recordkey = recordkey;
    }

    public String getPeriod() { return period; }

    public void setPeriod(String period) { this.period = period; }

    public BigDecimal getSteps() {
        return steps;
    }

    public void setSteps(BigDecimal steps) {
        this.steps = steps;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public String getRecordkey() {
        return recordkey;
    }

    public void setRecordkey(String recordkey) {
        this.recordkey = recordkey;
    }

    public BigDecimal getDistance() { return distance; }

    public void setDistance(BigDecimal distance) { this.distance = distance; }
}
