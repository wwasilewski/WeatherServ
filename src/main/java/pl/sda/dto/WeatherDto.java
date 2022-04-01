package pl.sda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherDto {

    private float temp;
    private float pressure;
    private int humidity;
    private float windSpeed;
    private float windDeg;
    private LocalDateTime date;
    private String locationName;
}
