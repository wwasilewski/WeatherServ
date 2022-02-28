package pl.sda.model;

import java.util.Objects;
import java.util.UUID;

public class Location {

    private String id = UUID.randomUUID().toString();
    private String region;
    private String countryName;
    private Coord coordinates;

    public Location(String region, String countryName, Coord coordinates) {
        this.region = region;
        this.countryName = countryName;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getRegion(),
                location.getRegion()) && Objects.equals(getCountryName(), location.getCountryName())
                && Objects.equals(getCoordinates(), location.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegion(), getCountryName(), getCoordinates());
    }
}
