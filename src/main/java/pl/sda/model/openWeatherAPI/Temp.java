package pl.sda.model.openWeatherAPI;

public class Temp {
    private float day;

    public Temp(float day) {
        this.day = day;
    }

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "day=" + day +
                '}';
    }
}
