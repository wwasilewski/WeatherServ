package pl.sda.controller;

import pl.sda.dto.LocationDto;
import pl.sda.dto.WeatherDto;
import pl.sda.service.LocationService;
import pl.sda.service.WeatherService;
import pl.sda.view.UserInterface;

import java.util.Scanner;

public class WeatherController {

    private final LocationService locationService = new LocationService();
    private final LocationController locationController = new LocationController();
    private final WeatherService weatherService = new WeatherService();
    private final Scanner sc = new Scanner(System.in);

    public void showWeatherMenu() {
        String choice;
        do {
            System.out.println("[1] Check weather for tomorrow");
            System.out.println("[2] Check weather for specific day in next 7 days");
            System.out.println("[3] Show all weather history");
            System.out.println("[0] Back to main menu");

            choice = sc.next();

            switch (choice) {
                case "1" -> showWeatherForTomorrow();
                case "2" -> showWeatherForSpecificDay();
                case "3" -> showAllWeather();
                case "0" -> UserInterface.showMenu();
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }

    private void showAllWeather() {

    }

    private void showWeatherForSpecificDay() {
        String locationName = getLocation().getName();
        int dayOfForecast = getDay();
        WeatherDto weatherDto = weatherService.saveWeatherForLocationForDefinedDay(locationName, dayOfForecast);
        System.out.println(locationName.concat(weatherDto.toString()));
    }

    private int getDay() {
        return 0;
    }

    public void showWeatherForTomorrow() {
        String locationName = getLocation().getName();
        WeatherDto weatherDto = weatherService.saveWeatherForLocationWithoutDay(locationName);
        System.out.println(locationName.concat(weatherDto.toString()));
    }

    private LocationDto getLocation() {
        System.out.println("Please enter the name of the location: ");
        String name = sc.nextLine();
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
}
