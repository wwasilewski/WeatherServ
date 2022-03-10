package pl.sda.service;

import com.google.gson.Gson;
import pl.sda.model.*;
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

//        OpenWeatherObject openWeatherObject = APIWeatherReader.APIWeatherReader();
//
//        Weather weather1 = readWeatherForSpecificDay(openWeatherObject, 3);
//        Weather weather2 = readWeatherForSpecificDay(openWeatherObject, 5);
//        Weather weather3 = readWeatherForSpecificDay(openWeatherObject, 12);
//
//        System.out.println(weather1);
//        System.out.println(weather2);
//        System.out.println(weather3);
//
//        saveWeatherToJSONFile(weather1);
//        saveWeatherToJSONFile(weather2);
//        saveWeatherToJSONFile(weather3);

        Location location1 = new Location("name", "region", "country", new Coord(33.44f, -94.04f));
        DateWeather dateWeather1 = readWeatherForLocation(location1, 3);
        System.out.println(dateWeather1);

        saveDateWeatherToJSONFile(dateWeather1);
    }

//    public static Weather readWeatherForSpecificDay(OpenWeatherObject weatherObject, int dayOfForecast) {
//        Weather result = new Weather();
//
//        if (dayOfForecast >= 0 && dayOfForecast <= 7) {
//            result.setTemp(weatherObject.getDaily()[dayOfForecast].getTemp().getDay());
//            result.setPressure(weatherObject.getDaily()[dayOfForecast].getPressure());
//            result.setHumidity(weatherObject.getDaily()[dayOfForecast].getHumidity());
//            result.setWind(new Wind(weatherObject.getDaily()[dayOfForecast].getWind_speed(),
//                    weatherObject.getDaily()[dayOfForecast].getWind_deg()));
//        } else {
//            result.setTemp(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getTemp().getDay());
//            result.setPressure(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getPressure());
//            result.setHumidity(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getHumidity());
//            result.setWind(new Wind(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_speed(),
//                    weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_deg()));
//        }
//        return result;
//    }

    public static DateWeather readWeatherForLocation(Location location, int dayOfForecast) throws URISyntaxException, IOException, InterruptedException {
        DateWeather result = new DateWeather();
        Weather weather = new Weather();

        float longitude = location.getCoord().getLon();
        float latitude = location.getCoord().getLat();
        OpenWeatherObject openWeatherObject = APIWeatherReader.APIWeatherReader(longitude, latitude);

        if (dayOfForecast >= 0 && dayOfForecast <= 7) {
            weather.setTemp(openWeatherObject.getDaily()[dayOfForecast].getTemp().getDay());
            weather.setPressure(openWeatherObject.getDaily()[dayOfForecast].getPressure());
            weather.setHumidity(openWeatherObject.getDaily()[dayOfForecast].getHumidity());
            weather.setWind(new Wind(openWeatherObject.getDaily()[dayOfForecast].getWind_speed(),
                    openWeatherObject.getDaily()[dayOfForecast].getWind_deg()));

            result.setTimestamp(openWeatherObject.getDaily()[dayOfForecast].getDt());
        } else {
            weather.setTemp(openWeatherObject.getDaily()[FORECAST_FOR_TOMORROW].getTemp().getDay());
            weather.setPressure(openWeatherObject.getDaily()[FORECAST_FOR_TOMORROW].getPressure());
            weather.setHumidity(openWeatherObject.getDaily()[FORECAST_FOR_TOMORROW].getHumidity());
            weather.setWind(new Wind(openWeatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_speed(),
                    openWeatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_deg()));

            result.setTimestamp(openWeatherObject.getDaily()[FORECAST_FOR_TOMORROW].getDt());
        }
        location.setMain(weather);
        result.setLocation(location);

        return result;
    }

    public static void saveDateWeatherToJSONFile(DateWeather dateWeather) {
        Gson gson = new Gson();

        try {
            Files.write(Paths.get(PATH), (gson.toJson(dateWeather) + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void saveWeatherToJSONFile(Weather weather) {
//        Gson gson = new Gson();
//
//        try {
//            Files.write(Paths.get(PATH), (gson.toJson(weather) + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
