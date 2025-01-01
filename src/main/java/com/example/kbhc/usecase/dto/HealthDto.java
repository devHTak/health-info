package com.example.kbhc.usecase.dto;

import com.example.kbhc.constants.HealthType;
import com.example.kbhc.framework.output.entity.HealthEntity;

import java.time.LocalDateTime;
import java.util.List;

public class HealthDto {
    private Long id;
    private String recordkey;
    private Integer sourceMode;
    private String productName;
    private String productVendor;
    private String sourceName;
    private String sourceType;
    private HealthType healthType;
    private LocalDateTime lastUpdate;
    private List<HealthActivityDto> healthActivities;

    public HealthDto(String recordkey, Integer sourceMode, String productName, String productVendor, String sourceName
                , String sourceType, HealthType healthType, LocalDateTime lastUpdate, List<HealthActivityDto> healthActivities) {
        this.recordkey = recordkey;
        this.sourceMode = sourceMode;
        this.productName = productName;
        this.productVendor = productVendor;
        this.sourceName = sourceName;
        this.sourceType = sourceType;
        this.healthType = healthType;
        this.lastUpdate = lastUpdate;
        this.healthActivities = healthActivities;
    }

    public HealthDto(Long id, String recordkey, Integer sourceMode, String productName, String productVendor, String sourceName, String sourceType
            , HealthType healthType, LocalDateTime lastUpdate) {
        this.id = id;
        this.recordkey = recordkey;
        this.sourceMode = sourceMode;
        this.productName = productName;
        this.productVendor = productVendor;
        this.sourceName = sourceName;
        this.sourceType = sourceType;
        this.healthType = healthType;
        this.lastUpdate = lastUpdate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordkey() {
        return recordkey;
    }

    public void setRecordkey(String recordkey) {
        this.recordkey = recordkey;
    }

    public Integer getSourceMode() {
        return sourceMode;
    }

    public void setSourceMode(Integer sourceMode) {
        this.sourceMode = sourceMode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public HealthType getHealthType() {
        return healthType;
    }

    public void setHealthType(HealthType healthType) {
        this.healthType = healthType;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<HealthActivityDto> getHealthActivities() {
        return healthActivities;
    }

    public void setHealthActivities(List<HealthActivityDto> healthActivities) {
        this.healthActivities = healthActivities;
    }
}
