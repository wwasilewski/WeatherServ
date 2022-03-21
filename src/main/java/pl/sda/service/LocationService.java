package pl.sda.service;

import pl.sda.dao.LocationDAO;
import pl.sda.dto.LocationDto;
import pl.sda.mapper.LocationMapper;
import pl.sda.model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationService {

    private final LocationDAO locationDAO = new LocationDAO();
    private final LocationMapper mapper = new LocationMapper();



    public void addLocation(LocationDto locationDto) {
        Location location = mapper.mapDtoToEntity(locationDto);
        locationDAO.saveLocation(location);
    }

    public LocationDto findByName(String name) {
        return mapper.mapEntityToDto(locationDAO.findByName(name));
    }

    public List<LocationDto> findAllLocations() {
        return locationDAO.findAllLocations().stream()
                .map(mapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
