package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.dto.WeatherDto;
import pl.sda.model.Weather;

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

    public WeatherDto getWeatherForLocation(String locationName, String date) {
        // przy pomocy OpenWeatherReader pobieramy najnowsze dane dla lokalizacji i danej daty
        // Weatherapireader -> dostaniecie OpenWeatherObject

        // przy pomocy LocationDAO na podstawie nazwy lokalizacji możecie spróbować znaleźć ją w bazie
        // dostaniecie obiekt Location

        // przy pomocy Mappera uzyskacie obiekt Weather

        // przy pomocy WeatherDAO zapiszecie razem obiekt Weather i Location

        // następnie trzeba przygotować obiekty Weather i Location do wyświetlenia na GUI
        // najlepiej w formie DTO i tutaj trzeba poprzez mappery upchąć tylko to co faktyczni jest niezbędne na GUI

        return null;
    }
}
