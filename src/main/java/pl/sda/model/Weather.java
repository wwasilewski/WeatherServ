package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weathers")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Integer id;

    @Column(name = "temp")
    private float temp;

    @Column(name = "pressure")
    private float pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "wind_speed")
    private float windSpeed; //wind speed

    @Column(name = "wind_dir")
    private float windDeg; //wind direction

    @Column(name = "timestamp")
    private long timestamp;
}
