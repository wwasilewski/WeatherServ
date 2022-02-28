package pl.sda.model;

import java.util.Objects;
import java.util.UUID;

public class Location {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String region;
    private String country;
    private Coord coord;
    private Weather main;

    public Location(String name, String region, String country, Coord coord) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.coord = coord;
    }

    public Location() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
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
        return Objects.equals(getId(), location.getId()) && Objects.equals(getName(), location.getName())
                && Objects.equals(getRegion(), location.getRegion()) && Objects.equals(getCountry(),
                location.getCountry()) && Objects.equals(getCoord(), location.getCoord())
                && Objects.equals(getMain(), location.getMain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRegion(), getCountry(), getCoord(), getMain());
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", coord=" + coord +
                ", main=" + main +
                '}';
    }
}
