package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.Location;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public abstract class APIWeatherReader<T> {

//    abstract String createAPICall(Location location);
//
//    public T readWeather(Location location) throws URISyntaxException, IOException, InterruptedException{
//        URI uri = new URI(createAPICall(location));
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(uri)
//                .build();
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        Gson mapper = new Gson();
//        return mapper.fromJson(response.body(), T.class);
//    }
}










