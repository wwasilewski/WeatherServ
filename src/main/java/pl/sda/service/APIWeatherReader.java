package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.Location;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIWeatherReader {

    public Location APIWeatherReader() throws URISyntaxException, IOException, InterruptedException {
    URI uri = new URI("https://api.openweathermap.org/data/2.5/onecall?lat=33.44&lon=-94.04&exclude=minutely,hourly,alerts&units=metric&appid=63cbd02cf64d7539e73a894b9ce3f787");
    HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build();
    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    Gson mapper = new Gson();
    return mapper.fromJson(response.body(), Location.class);
    }
}










