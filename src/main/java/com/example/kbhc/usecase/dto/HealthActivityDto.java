package com.example.kbhc.usecase.dto;

import com.example.kbhc.constants.CaloriesUnit;
import com.example.kbhc.constants.DistanceUnit;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HealthActivityDto {
    private Long id;
    private BigDecimal steps;
    private BigDecimal distance;
    private DistanceUnit distanceUnit;
    private BigDecimal calories;
    private CaloriesUnit caloriesUnit;
    private LocalDateTime periodFrom;
    private LocalDateTime periodTo;

    public HealthActivityDto(BigDecimal steps, BigDecimal distance, DistanceUnit distanceUnit, BigDecimal calories, CaloriesUnit caloriesUnit
            , LocalDateTime periodFrom, LocalDateTime periodTo) {
        this.steps = steps;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.calories = calories;
        this.caloriesUnit = caloriesUnit;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public HealthActivityDto(Long id, BigDecimal steps, BigDecimal distance, DistanceUnit distanceUnit, BigDecimal calories, CaloriesUnit caloriesUnit
            , LocalDateTime periodFrom, LocalDateTime periodTo) {
        this.id = id;
        this.steps = steps;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.calories = calories;
        this.caloriesUnit = caloriesUnit;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public BigDecimal getSteps() {
        return steps;
    }

    public void setSteps(BigDecimal steps) {
        this.steps = steps;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public CaloriesUnit getCaloriesUnit() {
        return caloriesUnit;
    }

    public void setCaloriesUnit(CaloriesUnit caloriesUnit) {
        this.caloriesUnit = caloriesUnit;
    }

    public LocalDateTime getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(LocalDateTime periodFrom) {
        this.periodFrom = periodFrom;
    }

    public LocalDateTime getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(LocalDateTime periodTo) {
        this.periodTo = periodTo;
    }
}
