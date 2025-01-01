package com.example.kbhc.framework.output.repository;

import com.example.kbhc.framework.output.entity.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HealthRepository extends JpaRepository<HealthEntity, Long> {

}
