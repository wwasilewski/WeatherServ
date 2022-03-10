package pl.sda.model.openWeatherAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Daily {

    private long dt;
    private Temp temp;
    private int pressure;
    private int humidity;
    private float wind_speed;
    private int wind_deg;
}
