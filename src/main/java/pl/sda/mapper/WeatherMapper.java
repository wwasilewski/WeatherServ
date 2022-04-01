package pl.sda.mapper;

import pl.sda.dto.WeatherDto;
import pl.sda.model.Weather;
import pl.sda.service.LocationService;

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
                .timestamp(weather.getTimestamp())
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
                .timestamp(weatherDto.getTimestamp())
                .location(locationMapper.mapDtoToEntity(locationService.findByName(weatherDto.getLocationName())))
                .build();
    }
}
