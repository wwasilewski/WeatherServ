package pl.sda.model;

import java.util.Objects;

public class DateWeather {

    private Location location;
    private long timestamp; //dt in Daily

    public DateWeather() {
    }

    public DateWeather(Location location, long timestamp) {
        this.location = location;
        this.timestamp = timestamp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateWeather that = (DateWeather) o;
        return getTimestamp() == that.getTimestamp() && Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), getTimestamp());
    }

    @Override
    public String toString() {
        return "DateWeather{" +
                "location=" + location +
                ", timestamp=" + timestamp +
                '}';
    }
}
