package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weathers")
@Builder
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Integer id;

    @Column(name = "temperature")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

}
