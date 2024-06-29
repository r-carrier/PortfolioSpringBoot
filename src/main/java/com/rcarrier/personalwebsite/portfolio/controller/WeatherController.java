package com.rcarrier.personalwebsite.portfolio.controller;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.repository.RealtimeWeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {


    private final RealtimeWeatherRepository realtimeWeatherRepository;

    Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    public WeatherController(RealtimeWeatherRepository realtimeWeatherRepository) {
        this.realtimeWeatherRepository = realtimeWeatherRepository;
    }

    @GetMapping("/realtime")
    ResponseEntity<List<RealtimeWeather>> allWeather() {
        List<RealtimeWeather> resultList = realtimeWeatherRepository.findFirstByOrderByIdDesc();
        return ResponseEntity.ok(resultList);
    }
}
