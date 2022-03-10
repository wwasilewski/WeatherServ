package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private float temp;
    private float pressure;
    private int humidity;
    private float windSpeed; //wind speed
    private float windDeg; //wind direction
}
