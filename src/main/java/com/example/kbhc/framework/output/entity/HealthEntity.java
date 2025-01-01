package com.example.kbhc.framework.output.entity;

import com.example.kbhc.constants.HealthType;
import com.example.kbhc.usecase.dto.HealthDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "health")
public class HealthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recordkey;
    private Integer sourceMode;
    private String productName;
    private String productVendor;
    private String sourceName;
    private String sourceType;

    @Enumerated(EnumType.STRING)
    private HealthType healthType;

    @Column(nullable = false)
    private LocalDateTime lastUpdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getRecordkey() {
        return recordkey;
    }

    public Integer getSourceMode() {
        return sourceMode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public HealthType getHealthType() {
        return healthType;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static HealthEntity save(HealthDto healthDto) {
        HealthEntity health = new HealthEntity();
        health.recordkey = healthDto.getRecordkey();
        health.sourceMode = healthDto.getSourceMode();
        health.productName = healthDto.getProductName();
        health.productVendor = healthDto.getProductVendor();
        health.sourceName = healthDto.getSourceName();
        health.sourceType = healthDto.getSourceType();
        health.healthType = healthDto.getHealthType();
        health.lastUpdate = healthDto.getLastUpdate();
        health.createdAt = LocalDateTime.now();
        health.updatedAt = LocalDateTime.now();
        return health;
    }

    public static HealthEntity byId(Long id) {
        HealthEntity health = new HealthEntity();
        health.id = id;
        return health;
    }

    public HealthDto convertToDto() {
        return new HealthDto(this.id, this.recordkey, this.sourceMode, this.productName, this.productVendor, this.sourceName, this.sourceType
                , this.healthType, this.lastUpdate);
    }
}
