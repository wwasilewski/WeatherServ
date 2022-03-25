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
//                case "3" -> showAllWeather();
                case "0" -> UserInterface.showMenu();
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }

//    private void showAllWeathers() {
//        List<WeatherDto> allWeathers = weatherService.getAllWeathers();
//
//        for (WeatherDto weatherDto : allWeathers) {
//            System.out.println(weatherDto.getPressure());
//        }
//    }

//    private void showAllWeathersForLocation() {
//        System.out.println("Provide the location: ");
//        String locationName = sc.next();
//        List<WeatherDto> weatherForLocation = weatherService.getWeatherForLocation(locationName);
//
//        for (WeatherDto weatherDto : weatherForLocation) {
//            System.out.println(weatherDto.toString());
//        }
//    }

    private void showWeatherForSpecificDay() {
        String locationName = getLocation().getName();
        int dayOfForecast = getDay();
        WeatherDto weatherDto = weatherService.saveWeatherForLocationForDefinedDay(locationName, dayOfForecast);
        System.out.println(locationName.concat(weatherDto.toString()));
    }

    private int getDay() {
        System.out.println("Provide the day of the forecast (1-7): ");
        String dayOfForecast = sc.next();

        return Integer.parseInt(dayOfForecast);
    }

    public void showWeatherForTomorrow() {
        String locationName = getLocation().getName();
        WeatherDto weatherDto = weatherService.saveWeatherForLocationWithoutDay(locationName);
        System.out.println(locationName.concat(weatherDto.toString()));
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
}
