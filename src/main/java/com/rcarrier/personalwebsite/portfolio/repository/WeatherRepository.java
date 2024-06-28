package com.rcarrier.personalwebsite.portfolio.repository;

import com.rcarrier.personalwebsite.portfolio.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositories allow us to access data
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
