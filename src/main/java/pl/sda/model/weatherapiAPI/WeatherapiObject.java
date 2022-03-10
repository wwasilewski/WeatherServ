package pl.sda.model.weatherapiAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherapiObject {

    private Forecastday[] forecastday;
}
