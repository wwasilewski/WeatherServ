package pl.sda.mapper;

import pl.sda.model.Weather;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

public class OpenWeatherObjectToWeatherMapper {

    private static final int FORECAST_FOR_TOMORROW = 1;

    public static Weather readWeatherForSpecificDay(OpenWeatherObject weatherObject, int dayOfForecast) {
        Weather result = new Weather();

        // tutaj uzupełniłbym dane równiez daty - ZROBIONE
        if (dayOfForecast >= 0 && dayOfForecast <= 7) {
            result.setTemp(weatherObject.getDaily()[dayOfForecast].getTemp().getDay());
            result.setPressure(weatherObject.getDaily()[dayOfForecast].getPressure());
            result.setHumidity(weatherObject.getDaily()[dayOfForecast].getHumidity());
            result.setWindSpeed(weatherObject.getDaily()[dayOfForecast].getWind_speed());
            result.setWindDeg(weatherObject.getDaily()[dayOfForecast].getWind_deg());
            result.setTimestamp(weatherObject.getDaily()[dayOfForecast].getDt());
        } else {
            result.setTemp(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getTemp().getDay());
            result.setPressure(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getPressure());
            result.setHumidity(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getHumidity());
            result.setWindSpeed(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_speed());
            result.setWindDeg(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getWind_deg());
            result.setTimestamp(weatherObject.getDaily()[FORECAST_FOR_TOMORROW].getDt());
        }
        return result;
    }
}
