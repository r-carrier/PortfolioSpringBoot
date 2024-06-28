package com.rcarrier.personalwebsite.portfolio.controller;

import com.rcarrier.personalwebsite.portfolio.repository.WeatherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherRepository weatherRepository;

    // inject WeatherRepository into the controller
    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

}
