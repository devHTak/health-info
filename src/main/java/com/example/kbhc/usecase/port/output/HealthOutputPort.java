package com.example.kbhc.usecase.port.output;

import com.example.kbhc.usecase.dto.HealthDto;

public interface HealthOutputPort {

    HealthDto save(HealthDto health);

}
