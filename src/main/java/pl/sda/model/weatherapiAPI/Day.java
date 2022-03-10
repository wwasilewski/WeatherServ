package pl.sda.model.weatherapiAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {

    private float avgtemp_c;
    private float maxwind_kph;
    private float avghumidity;
}
