package com.rcarrier.personalwebsite.portfolio.service;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;

import java.util.List;

public interface WeatherService {
    List<RealtimeWeather> getRealtimeWeather();
    List<WeatherForecast> getWeatherForecast();
}
