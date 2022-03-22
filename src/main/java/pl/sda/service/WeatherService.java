package pl.sda.service;

import pl.sda.dao.WeatherDAO;
import pl.sda.dto.LocationDto;
import pl.sda.dto.WeatherDto;
import pl.sda.mapper.OpenWeatherObjectToWeatherMapper;
import pl.sda.mapper.WeatherMapper;
import pl.sda.model.Weather;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherService {

    private final OpenWeatherReader openWeatherReader = new OpenWeatherReader();
    private final LocationService locationService = new LocationService();
    private final WeatherDAO weatherDAO = new WeatherDAO();
    private final WeatherMapper weatherMapper = new WeatherMapper();

    public void saveWeatherForLocationWithoutDay(String locationName) throws URISyntaxException, IOException, InterruptedException {
        LocationDto location = locationService.findByName(locationName);
        OpenWeatherObject openWeatherObject = openWeatherReader.readWeather(location);
        Weather weather = OpenWeatherObjectToWeatherMapper.readWeatherForSpecificDay(openWeatherObject, 8);
        weatherDAO.save(weather);
    }

    public void saveWeatherForLocationForDefinedDay(String locationName, int dayOfForecast) throws URISyntaxException, IOException, InterruptedException {
        LocationDto location = locationService.findByName(locationName);
        OpenWeatherObject openWeatherObject = openWeatherReader.readWeather(location);
        Weather weather = OpenWeatherObjectToWeatherMapper.readWeatherForSpecificDay(openWeatherObject, dayOfForecast);
        weatherDAO.save(weather);
    }

    public List<WeatherDto> getWeatherForLocation(String locationName) {
        List<Weather> weatherList = weatherDAO.findWeathersByCity(locationName);
        return weatherList.stream()
                .map(weatherMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
// przy pomocy OpenWeatherReader pobieramy najnowsze dane dla lokalizacji i danej daty
// Weatherapireader -> dostaniecie OpenWeatherObject

// przy pomocy LocationDAO na podstawie nazwy lokalizacji możecie spróbować znaleźć ją w bazie
// dostaniecie obiekt Location

// przy pomocy Mappera uzyskacie obiekt Weather

// przy pomocy WeatherDAO zapiszecie razem obiekt Weather i Location

// następnie trzeba przygotować obiekty Weather i Location do wyświetlenia na GUI
// najlepiej w formie DTO i tutaj trzeba poprzez mappery upchąć tylko to co faktyczni jest niezbędne na GUI
