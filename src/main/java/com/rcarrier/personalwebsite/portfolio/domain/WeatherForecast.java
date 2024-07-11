package com.rcarrier.personalwebsite.portfolio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

// @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store
// id, name and description are attributes of our Item domain object
@Entity
@Table(name = "t_forecast", schema = "fw1")
public class WeatherForecast {

    private @Id @GeneratedValue Long id;
    private @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime requestDate;
    private String locationName;
    private Double temperatureMin;
    private Double temperatureMax;
    private Integer cloudCover;
    private Integer precipProbability;
    private Integer rainIntensityAvg;
    private Integer weatherCodeMin;
    private Integer weatherCodeMax;
    private @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime forecastDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Integer getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Integer precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Integer getRainIntensityAvg() {
        return rainIntensityAvg;
    }

    public void setRainIntensityAvg(Integer rainIntensityAvg) {
        this.rainIntensityAvg = rainIntensityAvg;
    }

    public Integer getWeatherCodeMin() {
        return weatherCodeMin;
    }

    public void setWeatherCodeMin(Integer weatherCodeMin) {
        this.weatherCodeMin = weatherCodeMin;
    }

    public Integer getWeatherCodeMax() {
        return weatherCodeMax;
    }

    public void setWeatherCodeMax(Integer weatherCodeMax) {
        this.weatherCodeMax = weatherCodeMax;
    }

    public LocalDateTime getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(LocalDateTime forecastDate) {
        this.forecastDate = forecastDate;
    }
}
