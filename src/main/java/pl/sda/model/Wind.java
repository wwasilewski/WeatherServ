package pl.sda.model;

import java.util.Objects;

public class Wind {

    private float speed;
    private float deg; //wind direction

    public Wind(float speed, float deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wind wind = (Wind) o;
        return Float.compare(wind.getSpeed(), getSpeed()) == 0 && Float.compare(wind.getDeg(), getDeg()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpeed(), getDeg());
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
