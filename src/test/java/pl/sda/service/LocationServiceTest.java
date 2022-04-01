package pl.sda.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sda.dao.LocationDAO;
import pl.sda.dto.LocationDto;
import pl.sda.model.Location;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LocationServiceTest {

    private static final LocationService locationService = new LocationService();
    private static final LocationDAO locationDAO = new LocationDAO();
    private static final LocationDto locationDto = new LocationDto(
            "Koszalin",
            "Pomerania",
            "Poland",
            16.18f, 54.2f);


    @BeforeAll
    public static void cleanBefore() {
        List<Location> allLocations = locationDAO.findAllLocations();
        allLocations.forEach(locationDAO::deleteLocation);
    }

    @AfterEach
    public void cleanAfterEach() {
        List<Location> allLocations = locationDAO.findAllLocations();
        allLocations.forEach(locationDAO::deleteLocation);
    }

    @Test
    public void shouldDeleteAll() {
        locationService.deleteAll();
        assertThat(locationService.findAllLocations()).isEmpty();
    }

    @Test
    void shouldAddLocation() {
        locationService.addLocation(locationDto);
        assertThat(locationService.findByName("Koszalin")).isEqualTo(locationDto);
    }

    @Test
    void shouldFindByName() {
        locationService.addLocation(locationDto);
        assertThat(locationService.findByName("Koszalin")).isEqualTo(locationDto);
    }

    @Test
    void shouldFindAllLocations() {
        locationService.addLocation(locationDto);
        List<LocationDto> allLocations = locationService.findAllLocations();
        assertThat(allLocations.size()).isEqualTo(1);
    }
}