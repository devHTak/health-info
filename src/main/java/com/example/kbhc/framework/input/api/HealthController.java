package com.example.kbhc.framework.input.api;

import com.example.kbhc.framework.dto.HealthResponse;
import com.example.kbhc.framework.dto.ResponseInfo;
import com.example.kbhc.usecase.dto.HealthSummaryDto;
import com.example.kbhc.usecase.port.HealthUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HealthController {

    private final HealthUsecase healthUsecase;

    public HealthController(HealthUsecase healthUsecase) {
        this.healthUsecase = healthUsecase;
    }

    @GetMapping("/healths")
    public ResponseInfo<List<HealthResponse>> getAllHealths(@RequestParam String type) {
        List<HealthResponse> healths = healthUsecase.findAllHealthSummaryInfo(type).stream()
                .map(this::convertToResponse).collect(Collectors.toList());
        return new ResponseInfo<>(HttpStatus.OK.value(), "OK", healths);
    }

    private HealthResponse convertToResponse(HealthSummaryDto dto) {
        return new HealthResponse(dto.getPeriod(), dto.getSteps(), dto.getDistance(), dto.getCalories(), dto.getRecordkey());
    }
}
