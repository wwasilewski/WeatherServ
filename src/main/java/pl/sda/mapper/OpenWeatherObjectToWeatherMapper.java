package pl.sda.mapper;

import pl.sda.model.Weather;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

public class OpenWeatherObjectToWeatherMapper {

    private static final int FORECAST_FOR_TOMORROW = 1;

    public static Weather readWeatherForSpecificDay(OpenWeatherObject weatherObject, int dayOfForecast) {
        Weather result = new Weather();

        // tutaj uzupełniłbym dane równiez daty - ZROBIONE
        if (dayOfForecast >= 0 && dayOfForecast <= 7) {
            mapApiCallToWeatherObject(weatherObject, dayOfForecast, result);
        } else {
            mapApiCallToWeatherObject(weatherObject, FORECAST_FOR_TOMORROW, result);
        }
        return result;
    }

    private static void mapApiCallToWeatherObject(OpenWeatherObject weatherObject, int dayOfForecast, Weather result) {
        result.setTemp(weatherObject.getDaily()[dayOfForecast].getTemp().getDay());
        result.setPressure(weatherObject.getDaily()[dayOfForecast].getPressure());
        result.setHumidity(weatherObject.getDaily()[dayOfForecast].getHumidity());
        result.setWindSpeed(weatherObject.getDaily()[dayOfForecast].getWind_speed());
        result.setWindDeg(weatherObject.getDaily()[dayOfForecast].getWind_deg());
        result.setTimestamp(weatherObject.getDaily()[dayOfForecast].getDt());
    }
}
