package pl.sda.model.openWeatherAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherObject {

    private float lat;
    private float lon;
    private Daily[] daily;
}
