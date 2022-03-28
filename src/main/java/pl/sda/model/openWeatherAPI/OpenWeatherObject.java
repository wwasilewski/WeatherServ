package pl.sda.model.openWeatherAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.dto.LocationDto;
import pl.sda.model.Location;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherObject {

    private float lat;
    private float lon;
    private Daily[] daily;
}
