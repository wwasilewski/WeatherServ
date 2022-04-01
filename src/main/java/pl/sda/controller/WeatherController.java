package pl.sda.controller;

import pl.sda.dto.LocationDto;
import pl.sda.dto.WeatherDto;
import pl.sda.service.LocationService;
import pl.sda.service.WeatherService;
import pl.sda.view.UserInterface;

import java.util.List;
import java.util.Scanner;

public class WeatherController {

    private static final LocationService locationService = new LocationService();
    private static final LocationController locationController = new LocationController();
    private static final WeatherService weatherService = new WeatherService();
    private static final Scanner sc = new Scanner(System.in);


    public void showAllWeathers() {
        List<WeatherDto> allWeathers = weatherService.getAllWeathers();
        allWeathers.stream()
                .map(WeatherController::printWeatherDto)
                .forEach(System.out::println);
    }

    public void showAllWeathersForLocation() {
        System.out.println("Provide the location: ");
        String locationName = sc.next();
        List<WeatherDto> weatherForLocation = weatherService.getWeatherForLocation(locationName);
        weatherForLocation.stream()
                .map(WeatherController::printWeatherDto)
                .forEach(System.out::println);
    }

    public void showWeatherForSpecificDay() {
        String locationName = getLocation().getName();
        int dayOfForecast = getDay();
        WeatherDto weatherDto = weatherService.saveWeatherForLocationForDefinedDay(locationName, dayOfForecast);
        System.out.println(printWeatherDto(weatherDto));
    }

    private int getDay() {
        System.out.println("Provide the day of the forecast (1-7): ");
        String dayOfForecast = sc.next();

        return Integer.parseInt(dayOfForecast);
    }

    public void showWeatherForTomorrow() {
        String locationName = getLocation().getName();
        WeatherDto weatherDto = weatherService.saveWeatherForLocationWithoutDay(locationName);
        System.out.println(printWeatherDto(weatherDto));
    }

    private LocationDto getLocation() {
        System.out.println("Please enter the name of the location: ");
        String name = sc.next();
        LocationDto result = locationService.findByName(name);
        if (result != null) {
            return result;
        }
        showGetLocationSubmenu();
        return null;
    }

    private void showGetLocationSubmenu() {
        System.out.println("Location with given name doesn't exist. Choose option by number: ");
        String choice;
        do {
            System.out.println("[1] Write name of the location again");
            System.out.println("[2] Show all locations");
            System.out.println("[0] Back to main menu");

            choice = sc.next();

            switch (choice) {
                case "1" -> getLocation();
                case "2" -> locationController.showAllLocations();
                case "0" -> UserInterface.showMenu();
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }

    private static String printWeatherDto(WeatherDto weatherDto) {
        return "Location: " + weatherDto.getLocationName()
                + ", date: " + weatherDto.getTimestamp()
                + ", temperature: " + weatherDto.getTemp() + " C"
                + ", pressure: " + weatherDto.getPressure() + " hPa"
                + ", humidity: " + weatherDto.getHumidity() + "%"
                + ", wind speed: " + weatherDto.getWindSpeed() + " km/h"
                + ", wind direction: " + weatherDto.getWindDeg() + ".";
    }
}
