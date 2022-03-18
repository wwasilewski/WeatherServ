package pl.sda.dao;

import org.junit.jupiter.api.Test;
import pl.sda.model.Location;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LocationDAOTest {

    private LocationDAO locationDAO = new LocationDAO();

    @Test
    void shouldFindByCityNameIfExists() {
        Location location = new Location();
        location.setName("imie1");
        location.setCountry("PL");
        locationDAO.saveLocation(location);
        String name = "imie1";
        Location foundLocation = locationDAO.findByName(name);
        assertThat(foundLocation.getName()).isEqualTo(name);
    }

    @Test
    void shouldNotFindByCityNameIfDoesntExists() {
        String name = "random";
        Location foundLocation = locationDAO.findByName(name);
        assertThat(foundLocation).isNull();
    }

    @Test
    void doNotSaveLocationIfCityNameIsEmpty() {
        Location location = new Location();
        location.setCountry("PL");
        locationDAO.saveLocation(location);
        List<Location> allLocations = locationDAO.findAllLocations();
        assertThat(allLocations).isEmpty();
    }

    @Test
    void doNotSaveLocationIfCountryNameIsEmpty() {
    }

    @Test
    void saveLocationIfRegionIsNull() {
    }

    @Test
    void doNotSaveLocationIfCoordinatesAreIncorrect() {
    }


    @Test
    void findAllLocationsEmptyList() {
        List<Location> allLocations = locationDAO.findAllLocations();
        assertThat(allLocations).isEmpty();
    }

    @Test
    void findAllLocationsOneLocation() {
        Location location = new Location();
        location.setName("imie1");
        location.setCountry("PL");
        locationDAO.saveLocation(location);
        List<Location> allLocations = locationDAO.findAllLocations();
        assertThat(allLocations.size()).isEqualTo(1);
    }
}