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
@Table(name = "t_realtime_weather", schema = "fw1")
public class RealtimeWeather {

    // @Id indicates primary key and automatically populated by JPA provider
    private @Id @GeneratedValue Long id;
    private @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime requestDate;
    private String locationName;
    private Double temperature;
    private Integer cloudCover;
    private Integer precipProbability;
    private Integer rainIntensity;
    private Integer weatherCode;

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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
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

    public Integer getRainIntensity() {
        return rainIntensity;
    }

    public void setRainIntensity(Integer rainIntensity) {
        this.rainIntensity = rainIntensity;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }
}
