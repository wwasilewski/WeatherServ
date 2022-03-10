package pl.sda.service;

import com.google.gson.Gson;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WeatherService {

    private static final String PATH = "src/main/resources/weather.json";


    public static void saveWeatherToJSONFile(Weather weather) {
        Gson gson = new Gson();

        try {
            Files.write(Paths.get(PATH), (gson.toJson(weather) + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
