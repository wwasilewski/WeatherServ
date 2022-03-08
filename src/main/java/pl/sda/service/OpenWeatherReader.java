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

public class OpenWeatherReader implements APIWeatherReader{

    @Override
    public String createAPICall(Location location) {
        String lat = String.valueOf(location.getCoord().getLat());
        String lon = String.valueOf(location.getCoord().getLon());
        return "https://api.openweathermap.org/data/2.5/onecall?lat=".concat(lat).concat("&lon=").concat(lon).concat("&exclude=minutely,hourly,alerts&units=metric&appid=63cbd02cf64d7539e73a894b9ce3f787");
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