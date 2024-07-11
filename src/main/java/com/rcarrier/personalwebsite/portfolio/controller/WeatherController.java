package com.rcarrier.personalwebsite.portfolio.controller;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;
import com.rcarrier.personalwebsite.portfolio.repository.RealtimeWeatherRepository;
import com.rcarrier.personalwebsite.portfolio.repository.WeatherForecastRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {


    private final RealtimeWeatherRepository realtimeWeatherRepository;
    private final WeatherForecastRepository weatherForecastRepository;

    Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    public WeatherController(RealtimeWeatherRepository realtimeWeatherRepository, WeatherForecastRepository weatherForecastRepository) {
        this.realtimeWeatherRepository = realtimeWeatherRepository;
        this.weatherForecastRepository = weatherForecastRepository;
    }

    @GetMapping("/realtime")
    ResponseEntity<List<RealtimeWeather>> getRealtimeWeather() {
        List<RealtimeWeather> resultList = realtimeWeatherRepository.findFirstByOrderByIdDesc();
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/forecast")
    ResponseEntity<List<WeatherForecast>> getWeatherForecast() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);
        List<WeatherForecast> resultList = weatherForecastRepository.findByRequestDateBetween(startOfDay, endOfDay);
        return ResponseEntity.ok(resultList);
    }
}
