package com.example.kbhc.usecase.port.output;

import com.example.kbhc.usecase.dto.HealthActivityDto;
import com.example.kbhc.usecase.dto.HealthDto;

import java.util.List;

public interface HealthActivityOutputPort {
    List<HealthActivityDto> saveAll(List<HealthActivityDto> healthActivities, HealthDto healthDto);

    List<Object[]> findHealthDailySummaryInfo();

    List<Object[]> findHealthMonthlySummaryInfo();
}
