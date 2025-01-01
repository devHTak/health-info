package com.example.kbhc.usecase.port;

import com.example.kbhc.usecase.dto.HealthDto;
import com.example.kbhc.usecase.dto.HealthSummaryDto;

import java.util.List;

public interface HealthUsecase {
    List<HealthDto> saveAll(List<HealthDto> healths);

    List<HealthSummaryDto> findAllHealthSummaryInfo(String type);
}
