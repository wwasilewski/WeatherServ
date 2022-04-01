package pl.sda.controller;

import pl.sda.dto.LocationDto;
import pl.sda.dto.WeatherDto;
import pl.sda.service.LocationService;
import pl.sda.service.WeatherService;
import pl.sda.view.UserInterface;

import java.time.format.DateTimeFormatter;
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
        System.out.println("Please enter the location: ");
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
        System.out.println("Please enter the day of the forecast (1-7): ");
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
                + " " + weatherDto.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                + ", temperature: " + weatherDto.getTemp() + " C"
                + ", pressure: " + weatherDto.getPressure() + " hPa"
                + ", humidity: " + weatherDto.getHumidity() + "%"
                + ", wind speed: " + weatherDto.getWindSpeed() + " km/h"
                + ", wind direction: " + getWindName(weatherDto) + ".";
    }

    private static String getWindName(WeatherDto weatherDto) {
        float windDeg = weatherDto.getWindDeg();
        if (windDeg >= 22.5 && windDeg < 67.5) {
            return "north-east";
        } else if (windDeg < 112.5) {
            return "east";
        } else if (windDeg < 157.5) {
            return "south-east";
        } else if (windDeg < 202.5) {
            return "south";
        } else if (windDeg < 247.5) {
            return "south-west";
        } else if (windDeg < 292.5) {
            return "west";
        } else if (windDeg < 337.5) {
            return "north-west";
        } else {
            return "north";
        }
    }
}
