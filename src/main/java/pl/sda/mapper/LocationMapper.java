package pl.sda.mapper;

import pl.sda.dto.LocationDto;
import pl.sda.model.Location;

public class LocationMapper implements Mapper<LocationDto, Location> {

    @Override
    public Location mapDtoToEntity(LocationDto locationDto) {
        return Location.builder()
                .name(locationDto.getName())
                .region(locationDto.getRegion())
                .country(locationDto.getCountry())
                .longitude(locationDto.getLongitude())
                .latitude(locationDto.getLatitude())
                .build();
    }

    @Override
    public LocationDto mapEntityToDto(Location location) {
        return LocationDto.builder()
                .name(location.getName())
                .region(location.getRegion())
                .country(location.getCountry())
                .longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
    }
}
