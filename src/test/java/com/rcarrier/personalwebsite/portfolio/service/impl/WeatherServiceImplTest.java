package com.rcarrier.personalwebsite.portfolio.service.impl;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;
import com.rcarrier.personalwebsite.portfolio.repository.RealtimeWeatherRepository;
import com.rcarrier.personalwebsite.portfolio.repository.WeatherForecastRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WeatherServiceImplTest {

    @Mock
    private RealtimeWeatherRepository realtimeWeatherRepository;

    @Mock
    private WeatherForecastRepository weatherForecastRepository;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRealtimeWeatherTest() {
        RealtimeWeather weather = new RealtimeWeather();
        List<RealtimeWeather> weatherList = Collections.singletonList(weather);

        when(realtimeWeatherRepository.findFirstByOrderByIdDesc()).thenReturn(weatherList);

        List<RealtimeWeather> result = weatherService.getRealtimeWeather();

        assertEquals(weatherList, result);
    }

    @Test
    void getWeatherForecastTest() {
        WeatherForecast forecast = new WeatherForecast();
        List<WeatherForecast> forecastList = Collections.singletonList(forecast);
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        when(weatherForecastRepository.findByRequestDateBetween(startOfDay, endOfDay)).thenReturn(forecastList);

        List<WeatherForecast> result = weatherService.getWeatherForecast();

        assertEquals(forecastList, result);
    }
}
