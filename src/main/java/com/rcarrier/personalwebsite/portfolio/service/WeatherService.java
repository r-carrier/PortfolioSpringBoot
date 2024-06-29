package com.rcarrier.personalwebsite.portfolio.service;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.repository.RealtimeWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class WeatherService {

    private final RealtimeWeatherRepository realtimeWeatherRepository;

    @Autowired
    public WeatherService(RealtimeWeatherRepository realtimeWeatherRepository) {
        this.realtimeWeatherRepository = realtimeWeatherRepository;
    }

    public Optional<RealtimeWeather> getRealtimeWeatherByID(Long id) {
        return realtimeWeatherRepository.findById(id);
    }
}
