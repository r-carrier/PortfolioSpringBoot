package com.rcarrier.personalwebsite.portfolio.controller;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;
import com.rcarrier.personalwebsite.portfolio.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/realtime")
    public ResponseEntity<List<RealtimeWeather>> getRealtimeWeather() {
        try {
            LOGGER.info("Getting Realtime Weather");
            List<RealtimeWeather> resultList = weatherService.getRealtimeWeather();
            return ResponseEntity.ok(resultList);
        } catch (Exception e) {
            LOGGER.error("Failed to get Realtime Weather with error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/forecast")
    public ResponseEntity<List<WeatherForecast>> getWeatherForecast() {
        try {
            LOGGER.info("Getting Weather Forecast");
            List<WeatherForecast> resultList = weatherService.getWeatherForecast();
            return ResponseEntity.ok(resultList);
        } catch (Exception e) {
            LOGGER.error("Failed to get Weather Forecast with error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
