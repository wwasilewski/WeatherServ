package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.Weather;
import pl.sda.model.Wind;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WeatherService {

    private static final String PATH = "src/main/resources/weather.json";
    private static final int FORECAST_FOR_TOMORROW = 1;

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        OpenWeatherObject openWeatherObject = APIWeatherReader.APIWeatherReader();

        Weather weather1 = readWeatherForSpecificDay(openWeatherObject, 3);
        Weather weather2 = readWeatherForSpecificDay(openWeatherObject, 5);
        Weather weather3 = readWeatherForSpecificDay(openWeatherObject, 12);

        System.out.println(weather1);
        System.out.println(weather2);
        System.out.println(weather3);

        saveWeatherToJSONFile(weather1);
        saveWeatherToJSONFile(weather2);
        saveWeatherToJSONFile(weather3);
    }

    public static Weather readWeatherForSpecificDay(OpenWeatherObject weatherObject, int dayOfForecast) {
        Weather result = new Weather();

        if (dayOfForecast >= 0 && dayOfForecast <= 7) {
            result.setTemp(weatherObject.getDaily()[dayOfForecast].getTemp().getDay());
            result.setPressure(weatherObject.getDaily()[dayOfForecast].getPressure());
            result.setHumidity(weatherObject.getDaily()[dayOfForecast].getHumidity());
            result.setWind(new Wind(weatherObject.getDaily()[dayOfForecast].getWind_speed(),
                    weatherObject.getDaily()[dayOfForecast].getWind_deg()));
        } else {
            result.setTemp(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getTemp().getDay());
            result.setPressure(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getPressure());
            result.setHumidity(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getHumidity());
            result.setWind(new Wind(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_speed(),
                    weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_deg()));
        }
        return result;
    }

    public static void saveWeatherToJSONFile(Weather weather) {
        Gson gson = new Gson();

        try {
            Files.write(Paths.get(PATH), (gson.toJson(weather) + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
