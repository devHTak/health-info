package com.example.kbhc.framework.output.repository;

import com.example.kbhc.framework.output.entity.HealthActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthActivityRepository extends JpaRepository<HealthActivityEntity, Long> {

    @Query(value = """
            SELECT DATE_FORMAT(ha.period_from, '%Y-%m-%d') AS period
                , SUM(ha.steps) AS steps
                , SUM(ha.distance) AS distance
                , SUM(ha.calories) AS calories
                , h.recordkey
           FROM   health h
           JOIN   health_activity ha 
           ON     h.id = ha.health_id
           GROUP BY 
                  DATE_FORMAT(ha.period_from, '%Y-%m-%d')
                , h.recordkey
           """, nativeQuery = true)
    List<Object[]> findHealthDailySummary();

    @Query(value = """
           SELECT DATE_FORMAT(ha.period_from, '%Y-%m') AS period
                , SUM(ha.steps) AS steps
                , SUM(ha.distance) AS distance
                , SUM(ha.calories) AS calories
                , h.recordkey
           FROM   health h
           JOIN   health_activity ha 
           ON     h.id = ha.health_id
           GROUP BY 
                  DATE_FORMAT(ha.period_from, '%Y-%m')
                , h.recordkey
           """, nativeQuery = true)
    List<Object[]> findHealthMonthlySummary();
}
