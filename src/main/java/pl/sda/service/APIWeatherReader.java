package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.Location;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIWeatherReader {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println(APIWeatherReader(33.44f, -94.04f));
    }

    public static OpenWeatherObject APIWeatherReader(float lat, float lon) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://api.openweathermap.org/data/2.5/onecall?lat=" + lat
                + "&lon=" + lon + "&exclude=minutely,hourly,alerts&units=metric&appid=63cbd02cf64d7539e73a894b9ce3f787");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson mapper = new Gson();
        return mapper.fromJson(response.body(), OpenWeatherObject.class);
    }
}










