package pl.sda.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WeatherDAOTest {

    WeatherDAO weatherDAO = new WeatherDAO();

    @BeforeAll
    public static void setup() throws URISyntaxException, IOException, InterruptedException {
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
        weatherDAO.save(l1, 3);

        Weather w2 = new Weather();
        w2.setTemp(22.22f);
        w2.setPressure(22.22f);
        w2.setHumidity(22);
        w2.setWindSpeed(22.22f);
        w2.setWindDeg(22.22f);
        w2.setTimestamp(222222222L);
        weatherDAO.save(l1, 4);

        Weather w3 = new Weather();
        w3.setTemp(33.33f);
        w3.setPressure(33.33f);
        w3.setHumidity(33);
        w3.setWindSpeed(33.33f);
        w3.setWindDeg(33.33f);
        w3.setTimestamp(33333333L);
        weatherDAO.save(l2, 3);
    }

    @Test
    public void returnOneWeatherForIdTest(){

    }

    @Test
    public void returnAllThreeWeathersTest() {
        List<Weather> result = weatherDAO.findAllWeathers();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void returnTwoWeathersForCityTest() {
        List<Weather> result = weatherDAO.findWeathersByCity("Szczecin");
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void returnEmptyListWhenNoCityTest() {
        List<Weather> result = weatherDAO.findWeathersByCity("Wroclaw");
        assertThat(result.size()).isEqualTo(0);
    }


}

