package pl.sda.service;


import com.google.gson.Gson;
import pl.sda.model.DateWeather;
import pl.sda.model.Location;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherapiReader implements APIWeatherReader {

    @Override
    public String createAPICall(Location location) {
        String lat = String.valueOf(location.getCoord().getLat());
        String lon = String.valueOf(location.getCoord().getLon());
        return "http://api.weatherapi.com/v1/forecast.json?key=00d7e58184564cc29bf181335222802&q=".concat(lat).concat("'").concat(lon).concat("&days=5&aqi=no&alerts=no");
    }

    @Override
    public DateWeather readWeather(Location location) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(createAPICall(location));
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson mapper = new Gson();
        return mapper.fromJson(response.body(), DateWeather.class);
    }
}