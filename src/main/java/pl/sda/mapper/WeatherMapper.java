package pl.sda.mapper;

import pl.sda.dto.WeatherDto;
import pl.sda.model.Weather;
import pl.sda.service.LocationService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;


public class WeatherMapper implements Mapper<WeatherDto, Weather> {

    private final LocationService locationService = new LocationService();
    private final LocationMapper locationMapper = new LocationMapper();

    @Override
    public WeatherDto mapEntityToDto(Weather weather) {
        return WeatherDto.builder()
                .temp(weather.getTemp())
                .pressure(weather.getPressure())
                .humidity(weather.getHumidity())
                .windSpeed(weather.getWindSpeed())
                .windDeg(weather.getWindDeg())
                .date(LocalDateTime.ofInstant(Instant.ofEpochMilli(weather.getTimestamp() * 1000), TimeZone.getDefault().toZoneId()))
                .locationName(weather.getLocation().getName())
                .build();
    }

    @Override
    public Weather mapDtoToEntity(WeatherDto weatherDto) {
        return Weather.builder()
                .temp(weatherDto.getTemp())
                .pressure(weatherDto.getPressure())
                .humidity(weatherDto.getHumidity())
                .windSpeed(weatherDto.getWindSpeed())
                .windDeg(weatherDto.getWindDeg())
                .timestamp(weatherDto.getDate().atZone(TimeZone.getDefault().toZoneId()).toEpochSecond())
                .location(locationMapper.mapDtoToEntity(locationService.findByName(weatherDto.getLocationName())))
                .build();
    }
}
