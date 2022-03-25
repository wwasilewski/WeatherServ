package pl.sda.view;

import pl.sda.controller.LocationController;
import pl.sda.controller.WeatherController;

import java.util.Scanner;

public class UserInterface {

    private static final Scanner sc = new Scanner(System.in);
    private static final LocationController locationController = new LocationController();
    private static final WeatherController weatherController = new WeatherController();

    public static void showMenu() {
        String choice;
        do {
            System.out.println("[1] Add location");
            System.out.println("[2] Show all locations");
            System.out.println("[3] Weather Menu");
            System.out.println("[0] EXIT");

            choice = sc.next();

            switch (choice) {
                case "1" -> locationController.addLocation();
                case "2" -> locationController.showAllLocations();
                case "3" -> weatherController.showWeatherMenu();
                case "0" -> System.out.println("Good bye");
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }
}
