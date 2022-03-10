package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.Location;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APIWeatherReader<T> {


//    public T readWeather(Location location, String apiCall) throws URISyntaxException, IOException, InterruptedException{
//        URI uri = new URI(apiCall);
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(uri)
//                .build();
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        Gson mapper = new Gson();
//        return mapper.fromJson(response.body(),);
//    }
}










