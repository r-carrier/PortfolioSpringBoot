package com.rcarrier.personalwebsite.portfolio.service;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/weather")
public class HttpClientService {

    /**
     *
     * @return nothing for now
     * @throws IOException IOException
     * @throws InterruptedException InterruptedException
     */
    @GetMapping("/realtime")
    public ResponseEntity<?> getRealtimeWeather() throws IOException, InterruptedException {

        // Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Define the target URI
        URI uri = URI.create("https://api.tomorrow.io/v4/weather/realtime?apikey=JD52ypbZTRcg5Bh3hAvoGceKeDSZaE3N&location=14305%20US&units=imperial");

        // Create an HttpRequest for a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/realtime")
    public ResponseEntity<?> getWeatherForecast() throws IOException, InterruptedException {

        // Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Define the target URI
        URI uri = URI.create("https://api.tomorrow.io/v4/weather/forecast?location=14305%20US&apikey=JD52ypbZTRcg5Bh3hAvoGceKeDSZaE3N&timesteps=1d&units=imperial");

        // Create an HttpRequest for a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
