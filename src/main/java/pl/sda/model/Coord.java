package pl.sda.model;

import java.util.Objects;

public class Coord {

    private int lon; //longitude
    private int lat; //latitude

    public Coord(int lon, int lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return getLon() == coord.getLon() && getLat() == coord.getLat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLon(), getLat());
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
