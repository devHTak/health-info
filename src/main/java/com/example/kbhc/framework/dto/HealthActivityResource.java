package com.example.kbhc.framework.dto;

import com.example.kbhc.configuration.CustomDateDeserializer;
import com.example.kbhc.constants.CaloriesUnit;
import com.example.kbhc.constants.DistanceUnit;
import com.example.kbhc.usecase.dto.HealthActivityDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HealthActivityResource(
        Period period,
        Distance distance,
        Calories calories,
        BigDecimal steps
) {

    public HealthActivityDto convertToDto() {
        DistanceUnit distanceUnit;
        CaloriesUnit caloriesUnit;
        try {
            distanceUnit = DistanceUnit.getByUnit(distance.unit);
            caloriesUnit = CaloriesUnit.getByUnit(calories.unit);
        } catch (Exception e) {
            throw new IllegalArgumentException("Enum Convert Exception(Distance Type, Colory Unit) " + distance.unit + " " + calories.unit);
        }

        return new HealthActivityDto(this.steps, this.distance.value, distanceUnit, this.calories.value
                , caloriesUnit, period.from, period.to);
    }

    public static class Period {
        @JsonDeserialize(using = CustomDateDeserializer.class)
        private LocalDateTime from;
        @JsonDeserialize(using = CustomDateDeserializer.class)
        private LocalDateTime to;

        public LocalDateTime getFrom() {
            return from;
        }

        public void setFrom(LocalDateTime from) {
            this.from = from;
        }

        public LocalDateTime getTo() {
            return to;
        }

        public void setTo(LocalDateTime to) {
            this.to = to;
        }
    }

    public static class Distance {
        private String unit;
        private BigDecimal value;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }
    }

    public static class Calories {
        private String unit;
        private BigDecimal value;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }
    }
}
