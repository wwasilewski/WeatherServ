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
    private float longitude;
    private float latitude;
}
