package com.example.kbhc.framework.output;

import com.example.kbhc.framework.output.entity.HealthActivityEntity;
import com.example.kbhc.framework.output.entity.HealthEntity;
import com.example.kbhc.framework.output.repository.HealthActivityRepository;
import com.example.kbhc.usecase.dto.HealthActivityDto;
import com.example.kbhc.usecase.dto.HealthDto;
import com.example.kbhc.usecase.port.output.HealthActivityOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthActivityAdapter implements HealthActivityOutputPort {

    private HealthActivityRepository healthActivityRepository;

    public HealthActivityAdapter(HealthActivityRepository healthActivityRepository) {
        this.healthActivityRepository = healthActivityRepository;
    }

    @Override
    public List<HealthActivityDto> saveAll(List<HealthActivityDto> healthActivityDtos, HealthDto healthDto) {
        return healthActivityDtos.stream()
                .map(healthActivityDto -> this.generateNewHealthActivityEntity(healthDto, healthActivityDto))
                .map(healthActivity -> healthActivityRepository.save(healthActivity).convertToDto())
                .collect(Collectors.toList());
    }

    private HealthActivityEntity generateNewHealthActivityEntity(HealthDto healthDto, HealthActivityDto healthActivityDto) {
        HealthEntity health = HealthEntity.byId(healthDto.getId());
        HealthActivityEntity healthActivity = HealthActivityEntity.save(healthActivityDto, health);

        return healthActivity;
    }

    @Override
    public List<Object[]> findHealthDailySummaryInfo() {
        return healthActivityRepository.findHealthDailySummary();
    }

    @Override
    public List<Object[]> findHealthMonthlySummaryInfo() {
        return healthActivityRepository.findHealthMonthlySummary();
    }
}
