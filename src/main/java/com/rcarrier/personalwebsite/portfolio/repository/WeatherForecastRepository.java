package com.rcarrier.personalwebsite.portfolio.repository;

import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {
    List<WeatherForecast> findByRequestDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
