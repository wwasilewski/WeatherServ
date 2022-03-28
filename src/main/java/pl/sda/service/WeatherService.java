package pl.sda.service;

import pl.sda.dao.LocationDAO;
import pl.sda.dao.WeatherDAO;
import pl.sda.dto.LocationDto;
import pl.sda.dto.WeatherDto;
import pl.sda.mapper.LocationMapper;
import pl.sda.mapper.OpenWeatherObjectToWeatherMapper;
import pl.sda.mapper.WeatherMapper;
import pl.sda.model.Weather;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherService {

    private final OpenWeatherReader openWeatherReader = new OpenWeatherReader();
    private final LocationService locationService = new LocationService();
    private final WeatherDAO weatherDAO = new WeatherDAO();
    private final WeatherMapper weatherMapper = new WeatherMapper();
    private final LocationMapper locationMapper = new LocationMapper();
    private final LocationDAO locationDAO = new LocationDAO();

    public WeatherDto saveWeatherForLocationWithoutDay(String locationName) {
        LocationDto location = locationService.findByName(locationName);
        OpenWeatherObject openWeatherObject = openWeatherReader.readWeather(location);
        Weather weather = OpenWeatherObjectToWeatherMapper.readWeatherForSpecificDay(openWeatherObject, 8);
        weather.setLocation(locationMapper.mapDtoToEntity(location));
        weatherDAO.save(weather);
        return weatherMapper.mapEntityToDto(weather);
    }

    public WeatherDto saveWeatherForLocationForDefinedDay(String locationName, int dayOfForecast) {
        LocationDto location = locationService.findByName(locationName);
        OpenWeatherObject openWeatherObject = openWeatherReader.readWeather(location);
        Weather weather = OpenWeatherObjectToWeatherMapper.readWeatherForSpecificDay(openWeatherObject, dayOfForecast);
        weather.setLocation(locationDAO.findByName(location.getName()));
        weatherDAO.save(weather);
        return weatherMapper.mapEntityToDto(weather);
    }

    public List<WeatherDto> getWeatherForLocation(String locationName) {
        List<Weather> weatherList = weatherDAO.findWeathersByCity(locationName);
        return weatherList.stream()
                .map(weatherMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public List<WeatherDto> getAllWeathers() {
        List<Weather> weatherList = weatherDAO.findAllWeathers();
        return weatherList.stream()
                .map(weatherMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
