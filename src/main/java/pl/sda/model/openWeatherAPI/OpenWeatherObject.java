package pl.sda.model.openWeatherAPI;

import java.util.Arrays;

public class OpenWeatherObject {
    private float lat;
    private float lon;
    private Daily[] daily;

    public OpenWeatherObject(float lat, float lon, Daily[] daily) {
        this.lat = lat;
        this.lon = lon;
        this.daily = daily;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public Daily[] getDaily() {
        return daily;
    }

    public void setDaily(Daily[] daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "OpenWeatherObject{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", daily=" + Arrays.toString(daily) +
                '}';
    }
}
