package pl.sda.service;

import pl.sda.model.Location;
import pl.sda.model.weatherapiAPI.WeatherapiObject;

public class WeatherapiReader extends APIWeatherReader<WeatherapiObject> {

    private static final String APP_ID = "00d7e58184564cc29bf181335222802&q=";

    public String createAPICall(Location location) {
        String lat = String.valueOf(location.getLatitude());
        String lon = String.valueOf(location.getLongitude());
        return "http://api.weatherapi.com/v1/forecast.json?key="
                .concat(APP_ID)
                .concat(lat)
                .concat("'")
                .concat(lon)
                .concat("&days=5&aqi=no&alerts=no");
    }
}
