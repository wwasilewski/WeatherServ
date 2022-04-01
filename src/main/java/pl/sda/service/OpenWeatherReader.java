package pl.sda.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import pl.sda.dto.LocationDto;
import pl.sda.mapper.LocationMapper;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class OpenWeatherReader {

    private static final String APP_ID = "63cbd02cf64d7539e73a894b9ce3f787";
    private static final LocationMapper locationMapper = new LocationMapper();

    public static String createAPICall(LocationDto location) {
        String lat = String.valueOf(location.getLatitude());
        String lon = String.valueOf(location.getLongitude());
        return "https://api.openweathermap.org/data/2.5/onecall?lat="
                .concat(lat)
                .concat("&lon=")
                .concat(lon)
                .concat("&exclude=minutely,hourly,alerts&units=metric&appid=")
                .concat(APP_ID);
    }

    public OpenWeatherObject readWeather(LocationDto location) {
        URI uri = null;

        try {
            uri = new URI(createAPICall(location));
        } catch (URISyntaxException e) {
            log.error(e.getMessage(), e);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        Gson mapper = new Gson();

        return mapper.fromJson(response.body(), OpenWeatherObject.class);

    }
}
