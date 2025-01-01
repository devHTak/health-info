package com.example.kbhc.framework.dto;


import java.math.BigDecimal;

public record HealthResponse(
        String period,
        BigDecimal steps,
        BigDecimal distance,
        BigDecimal calories,
        String recordkey
) {
}
