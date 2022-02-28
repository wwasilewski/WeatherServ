package pl.sda.model;

import java.util.Objects;

public class Weather {

    private float temperature;
    private float pressure;
    private int humidity;
    private Wind wind;

    public Weather(float temperature, float pressure, int humidity, Wind wind) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Float.compare(weather.getTemperature(), getTemperature()) == 0
                && Float.compare(weather.getPressure(), getPressure()) == 0
                && getHumidity() == weather.getHumidity() && Objects.equals(getWind(), weather.getWind());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTemperature(), getPressure(), getHumidity(), getWind());
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", wind=" + wind +
                '}';
    }
}
