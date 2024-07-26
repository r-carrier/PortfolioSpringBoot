package com.rcarrier.personalwebsite.portfolio.controller;

import com.rcarrier.personalwebsite.portfolio.domain.RealtimeWeather;
import com.rcarrier.personalwebsite.portfolio.domain.WeatherForecast;
import com.rcarrier.personalwebsite.portfolio.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRealtimeWeatherTest() {
        RealtimeWeather weather = new RealtimeWeather();
        List<RealtimeWeather> weatherList = Collections.singletonList(weather);

        when(weatherService.getRealtimeWeather()).thenReturn(weatherList);

        ResponseEntity<List<RealtimeWeather>> response = weatherController.getRealtimeWeather();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(weatherList, response.getBody());
    }

    @Test
    void getWeatherForecastTest() {
        WeatherForecast forecast = new WeatherForecast();
        List<WeatherForecast> forecastList = Collections.singletonList(forecast);

        when(weatherService.getWeatherForecast()).thenReturn(forecastList);

        ResponseEntity<List<WeatherForecast>> response = weatherController.getWeatherForecast();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(forecastList, response.getBody());
    }
}
