package pl.sda.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherDAOTest {

    WeatherDAO weatherDAO = new WeatherDAO();

    @BeforeAll
    public static void setup() {
        LocationDAO locationDAO = new LocationDAO();
        WeatherDAO weatherDAO = new WeatherDAO();

        Location l1 = new Location();
        l1.setName("Szczecin");
        l1.setRegion("zach-pom");
        l1.setCountry("Poland");
        l1.setLongitude(11.11f);
        l1.setLatitude(11.11f);
        locationDAO.saveLocation(l1);

        Location l2 = new Location();
        l2.setName("Krakow");
        l2.setRegion("malopolskie");
        l2.setCountry("Poland");
        l2.setLongitude(22.22f);
        l2.setLatitude(22.22f);
        locationDAO.saveLocation(l2);

        Weather w1 = new Weather();
        w1.setTemp(11.11f);
        w1.setPressure(11.11f);
        w1.setHumidity(11);
        w1.setWindSpeed(11.11f);
        w1.setWindDeg(11.11f);
        w1.setTimestamp(111111111L);
        w1.setLocation(l1);
        weatherDAO.save(w1);

        Weather w2 = new Weather();
        w2.setTemp(22.22f);
        w2.setPressure(22.22f);
        w2.setHumidity(22);
        w2.setWindSpeed(22.22f);
        w2.setWindDeg(22.22f);
        w2.setTimestamp(222222222L);
        w2.setLocation(l1);
        weatherDAO.save(w2);

        Weather w3 = new Weather();
        w3.setTemp(33.33f);
        w3.setPressure(33.33f);
        w3.setHumidity(33);
        w3.setWindSpeed(33.33f);
        w3.setWindDeg(33.33f);
        w3.setTimestamp(33333333L);
        w3.setLocation(l2);
        weatherDAO.save(w3);
    }

    @Test
    public void saveWeatherTest() {
        Weather weather = new Weather();
        weather.setTemp(11.11f);
        weather.setPressure(11.11f);
        weather.setHumidity(11);
        weather.setWindSpeed(11.11f);
        weather.setWindDeg(11.11f);
        weather.setTimestamp(11111111L);
        weatherDAO.save(weather);

        Weather result = weatherDAO.findWeatherById(4);
        assertThat(result).isEqualTo(weather);
    }

    @Test
    public void returnAllWeatherTest() {
        List<Weather> result = weatherDAO.findAllWeather();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void returnTwoWeatherForCityTest() {
        List<Weather> result = weatherDAO.findWeatherByCity("Szczecin");
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void returnEmptyListWhenNoCityTest() {
        List<Weather> result = weatherDAO.findWeatherByCity("Wroclaw");
        assertThat(result.size()).isEqualTo(0);
    }
}
