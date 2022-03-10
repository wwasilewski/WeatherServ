package pl.sda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private float temp;
    private float pressure;
    private int humidity;
    private float windSpeed; //wind speed
    private float windDeg; //wind direction
    private LocalDateTime date; // na razie zostawiłem, potem jak będzie wiadomo co to jest to
                                // usuniemy albo dodamy do konstruktora

    public WeatherDto(float temp, float pressure, int humidity, float windSpeed, float windDeg) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }
}
