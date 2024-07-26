package com.rcarrier.personalwebsite.portfolio.service.impl;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;
import com.rcarrier.personalwebsite.portfolio.repository.RealtimeWeatherRepository;
import com.rcarrier.personalwebsite.portfolio.repository.WeatherForecastRepository;
import com.rcarrier.personalwebsite.portfolio.service.WeatherService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RealtimeWeatherRepository realtimeWeatherRepository;
    private final WeatherForecastRepository weatherForecastRepository;

    public WeatherServiceImpl(RealtimeWeatherRepository realtimeWeatherRepository, WeatherForecastRepository weatherForecastRepository) {
        this.realtimeWeatherRepository = realtimeWeatherRepository;
        this.weatherForecastRepository = weatherForecastRepository;
    }

    @Override
    public List<RealtimeWeather> getRealtimeWeather() {
        return realtimeWeatherRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<WeatherForecast> getWeatherForecast() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);
        return weatherForecastRepository.findByRequestDateBetween(startOfDay, endOfDay);
    }
}

