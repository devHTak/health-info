package com.example.kbhc.framework.output;

import com.example.kbhc.framework.output.entity.HealthEntity;
import com.example.kbhc.framework.output.repository.HealthRepository;
import com.example.kbhc.usecase.dto.HealthDto;
import com.example.kbhc.usecase.port.output.HealthOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthAdapter implements HealthOutputPort {

    private final HealthRepository healthRepository;

    public HealthAdapter(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    @Override
    public HealthDto save(HealthDto healthDto) {
        HealthEntity health = HealthEntity.save(healthDto);
        return healthRepository.save(health)
                .convertToDto();
    }
}
