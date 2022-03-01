package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.Weather;
import pl.sda.model.Wind;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WeatherService {

    private static final String PATH = "src/main/resources/weather.json";

//    public static void main(String[] args) {
//        Weather weather1 = new Weather(12f, 32f, 123, new Wind(32f, 123f));
//        String weatherString1 = changeWeatherObjectToString(weather1);
//
//
//        saveWeatherStringToFile(weatherString1);
//    }

    public static String changeWeatherObjectToString(Weather weather) {
        Gson gson = new Gson();

        return gson.toJson(weather);
    }

    public static void saveWeatherStringToFile(String weather) {
        Path path = Paths.get(PATH);
        byte[] strToBytes = (System.lineSeparator() + weather).getBytes();

        try {
            Files.write(path, strToBytes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
