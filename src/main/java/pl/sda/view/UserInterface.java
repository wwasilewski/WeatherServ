package pl.sda.view;

import pl.sda.controller.LocationController;
import pl.sda.controller.WeatherController;

import java.util.Scanner;

public class UserInterface {

    private static final Scanner sc = new Scanner(System.in);
    private static final LocationController locationController = new LocationController();
    private static final WeatherController weatherController = new WeatherController();
    private static String choice;

    public static void showMenu() {
        do {
            System.out.println("[1] Add location");
            System.out.println("[2] Show all locations");
            System.out.println("[3] Weather Menu");
            System.out.println("[0] EXIT");

            choice = sc.next();

            switch (choice) {
                case "1" -> locationController.addLocation();
                case "2" -> locationController.showAllLocations();
                case "3" -> showWeatherMenu();
                case "0" -> System.out.println("Good bye");
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }

    public static void showWeatherMenu() {
        do {
            System.out.println("[1] Check weather for tomorrow");
            System.out.println("[2] Check weather for specific day in next 7 days");
            System.out.println("[3] Show all weather history");
            System.out.println("[4] Show weather history for specific location");
            System.out.println("[5] Back to main menu");
            System.out.println("[0] EXIT");

            choice = sc.next();

            switch (choice) {
                case "1" -> weatherController.showWeatherForTomorrow();
                case "2" -> weatherController.showWeatherForSpecificDay();
                case "3" -> weatherController.showAllWeathers();
                case "4" -> weatherController.showAllWeathersForLocation();
                case "5" -> showMenu();
                case "0" -> System.out.println("Good bye");
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }
}
