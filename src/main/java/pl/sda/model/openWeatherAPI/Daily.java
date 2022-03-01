package pl.sda.model.openWeatherAPI;

import java.time.LocalDateTime;

public class Daily {
    private long dt;
    private Temp temp;
    private int pressure;
    private int humidity;
    private float wind_speed;
    private int wind_deg;

    public Daily(long dt, Temp temp, int pressure, int humidity, float wind_speed, int wind_deg) {
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", wind_speed=" + wind_speed +
                ", wind_deg=" + wind_deg +
                '}';
    }
}
