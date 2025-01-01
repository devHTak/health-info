package com.example.kbhc.framework.output.entity;

import com.example.kbhc.constants.CaloriesUnit;
import com.example.kbhc.constants.DistanceUnit;
import com.example.kbhc.usecase.dto.HealthActivityDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "health_activity")
public class HealthActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal steps;
    private BigDecimal distance;
    @Enumerated(EnumType.STRING)
    private DistanceUnit distanceUnit;
    private BigDecimal calories;

    @Enumerated(EnumType.STRING)
    private CaloriesUnit caloriesUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_id")
    private HealthEntity health;

    @Column(nullable = false)
    private LocalDateTime periodFrom;
    @Column(nullable = false)
    private LocalDateTime periodTo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static HealthActivityEntity save(HealthActivityDto healthActivityDto, HealthEntity health) {
        HealthActivityEntity healthActivity = new HealthActivityEntity();
        healthActivity.steps = healthActivityDto.getSteps();
        healthActivity.distance = healthActivityDto.getDistance();
        healthActivity.distanceUnit = healthActivityDto.getDistanceUnit();
        healthActivity.calories = healthActivityDto.getCalories();
        healthActivity.caloriesUnit = healthActivityDto.getCaloriesUnit();
        healthActivity.periodFrom = healthActivityDto.getPeriodFrom();
        healthActivity.periodTo = healthActivityDto.getPeriodTo();
        healthActivity.health = health;
        healthActivity.createdAt = LocalDateTime.now();
        healthActivity.updatedAt = LocalDateTime.now();
        return healthActivity;
    }

    public HealthActivityDto convertToDto() {
        return new HealthActivityDto(this.id, this.steps, this.distance, this.distanceUnit, this.calories, this.caloriesUnit
                , this.periodFrom, this.periodTo);
    }


}
