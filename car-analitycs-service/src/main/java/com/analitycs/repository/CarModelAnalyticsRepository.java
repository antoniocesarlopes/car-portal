package com.analitycs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analitycs.data.entity.CarModelAnalyticsEntity;

@Repository
public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long> {
    Optional<CarModelAnalyticsEntity> findByModel(String model);
}
