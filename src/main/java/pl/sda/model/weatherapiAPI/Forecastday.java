package pl.sda.model.weatherapiAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecastday {

    private long date_epoch;
    private Day day;
    private Hour hour;
}
