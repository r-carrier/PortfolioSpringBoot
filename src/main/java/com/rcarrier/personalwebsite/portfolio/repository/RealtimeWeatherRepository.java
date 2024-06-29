package com.rcarrier.personalwebsite.portfolio.repository;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// query methods https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
public interface RealtimeWeatherRepository extends JpaRepository<RealtimeWeather, Long> {
    List<RealtimeWeather> findFirstByOrderByIdDesc();;
}
