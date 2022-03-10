package pl.sda.service;


import com.google.gson.Gson;
import pl.sda.model.Location;
import pl.sda.model.weatherapiAPI.WeatherapiObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherapiReader{

    public String createAPICall(Location location) {
        String lat = String.valueOf(location.getLatitude());
        String lon = String.valueOf(location.getLongitude());
        return "http://api.weatherapi.com/v1/forecast.json?key=00d7e58184564cc29bf181335222802&q=".concat(lat).concat("'").concat(lon).concat("&days=5&aqi=no&alerts=no");
    }

    public WeatherapiObject readWeather(Location location) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(createAPICall(location));
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson mapper = new Gson();
        return mapper.fromJson(response.body(), WeatherapiObject.class);
    }
}
