package com.example.kbhc.usecase.port.input;

import com.example.kbhc.usecase.dto.HealthActivityDto;
import com.example.kbhc.usecase.dto.HealthDto;
import com.example.kbhc.usecase.dto.HealthSummaryDto;
import com.example.kbhc.usecase.port.HealthUsecase;
import com.example.kbhc.usecase.port.output.HealthActivityOutputPort;
import com.example.kbhc.usecase.port.output.HealthOutputPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthInputPort implements HealthUsecase {

    private final HealthOutputPort healthOutputPort;
    private final HealthActivityOutputPort healthActivityOutputPort;

    public HealthInputPort(HealthOutputPort healthOutputPort, HealthActivityOutputPort healthActivityOutputPort) {
        this.healthOutputPort = healthOutputPort;
        this.healthActivityOutputPort = healthActivityOutputPort;
    }

    @Override
    @Transactional
    public List<HealthDto> saveAll(List<HealthDto> healths) {
        return healths.stream()
                .map(health ->{
                    HealthDto saveHealth = healthOutputPort.save(health);
                    List<HealthActivityDto> healthActivities = healthActivityOutputPort.saveAll(health.getHealthActivities(), saveHealth);
                    saveHealth.setHealthActivities(healthActivities);
                    return saveHealth;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<HealthSummaryDto> findAllHealthSummaryInfo(String type) {
        List<Object[]> healths;
        if("Daily".equals(type)) {
            healths = healthActivityOutputPort.findHealthDailySummaryInfo();
        } else {
            healths = healthActivityOutputPort.findHealthMonthlySummaryInfo();
        }

        return healths.stream()
                .map(result -> new HealthSummaryDto(
                        (String) result[0], // period
                        (BigDecimal) result[1], // steps
                        (BigDecimal) result[2], // distance
                        (BigDecimal) result[3], // calories
                        (String) result[4] // recordkey
                )).collect(Collectors.toList());
    }
}
