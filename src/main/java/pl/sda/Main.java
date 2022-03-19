package pl.sda;

import pl.sda.dao.LocationDAO;
import pl.sda.dao.WeatherDAO;
import pl.sda.model.Location;
import pl.sda.model.Weather;
import pl.sda.view.UserInterface;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        UserInterface.showMenu();

        LocationDAO locationDAO = new LocationDAO();

        Location l1 = new Location();
        l1.setCountry("costam1");
        l1.setName("imie1");
        l1.setRegion("region1");
        l1.setCountry("kraj1");
        l1.setLongitude(-94.04f);
        l1.setLatitude(33.44f);

        locationDAO.saveLocation(l1);

        Location l2 = new Location();
        l2.setCountry("costam2");
        l2.setName("imie2");
        l2.setRegion("region2");
        l2.setCountry("kraj2");
        l2.setLongitude(22.22f);
        l2.setLatitude(22.22f);

        locationDAO.saveLocation(l2);

        Location l3 = new Location();
        l3.setCountry("costam3");
        l3.setName("imie3");
        l3.setRegion("region3");
        l3.setCountry("kraj3");
        l3.setLongitude(33.33f);
        l3.setLatitude(33.33f);

        locationDAO.saveLocation(l3);

        WeatherDAO weatherDAO = new WeatherDAO();
        weatherDAO.save(l1,5);

//        Location location = new Location();
//        location.setName("name");
//        location.setCountry("country");
//        location.setRegion("region");
//
//
//        location.setLongitude(-94.04f);
//        location.setLatitude(33.44f);

//        weatherDAO.save(location,5);
    }
}
