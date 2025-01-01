package com.example.kbhc.framework.dto;

import com.example.kbhc.configuration.CustomDateDeserializer;
import com.example.kbhc.constants.HealthType;
import com.example.kbhc.usecase.dto.HealthActivityDto;
import com.example.kbhc.usecase.dto.HealthDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record HealthResource(
        String recordkey,
        @JsonDeserialize(using = CustomDateDeserializer.class)
        LocalDateTime lastUpdate,
        String type,
        Data data
) {

    public HealthDto convertToDto() throws Exception {
        List<HealthActivityDto> healthActivities = this.data.entries.stream()
                .map(healthActivity -> healthActivity.convertToDto())
                .collect(Collectors.toList());

        HealthType healthType;
        try {
            healthType = HealthType.getByType(type);
        } catch (Exception e) {
            throw new Exception("Enum Convert Exception(Health Type) " + type);
        }

        return new HealthDto(this.recordkey, this.data.source.mode, this.data.source.product.name, this.data.source.product.vender
                , this.data.source.name, this.data.source.type, healthType, this.lastUpdate, healthActivities);

    }

    public static record Data(
            String memo,
            List<HealthActivityResource> entries,
            Source source
    ){}

    public static record Source(
            Integer mode,
            Product product,
            String name,
            String type
    ) { }

    public static record Product(
            String name,
            String vender
    ) { }
}
