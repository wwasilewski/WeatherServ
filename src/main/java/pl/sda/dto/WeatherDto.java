package pl.sda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherDto {

    private float temp;
    private float pressure;
    private int humidity;
    private float windSpeed; //wind speed
    private float windDeg; //wind direction
    private long timestamp; //date
}
