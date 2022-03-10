package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String region;
    private String country;
    private long longitude;
    private long latitude;
    private Weather main;

    public Location(String name, String region, String country, long longitude, long latitude) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
