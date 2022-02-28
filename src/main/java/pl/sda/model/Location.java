package pl.sda.model;

import java.util.Objects;
import java.util.UUID;

public class Location {

    private String id = UUID.randomUUID().toString();
    private String region;
    private String countryName;
    private Coord coordinates;
    private Weather main;

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

    public Weather getMain() {
        return main;
    }

    public void setMain(Weather main) {
        this.main = main;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getRegion(),
                location.getRegion()) && Objects.equals(getCountryName(), location.getCountryName())
                && Objects.equals(getCoordinates(), location.getCoordinates())
                && Objects.equals(getMain(), location.getMain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegion(), getCountryName(), getCoordinates(), getMain());
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", region='" + region + '\'' +
                ", countryName='" + countryName + '\'' +
                ", coordinates=" + coordinates +
                ", main=" + main +
                '}';
    }
}
