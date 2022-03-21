package pl.sda.view;

import pl.sda.controller.LocationController;

import java.util.Scanner;

public class UserInterface {

    private static final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private static String choice;
    private static LocationController locationController = new LocationController();


    public static void showMenu() {
        do {
            System.out.println("[1] Add location");
            System.out.println("[2] Show all locations");
            System.out.println("[3] Show weather for specific location");
            System.out.println("[0] EXIT");

            choice = sc.next();

            switch (choice) {
                case "1" -> locationController.addLocation();
                case "2" -> showAllLocations();
                case "3" -> showWeather();
                case "0" -> System.out.println("Good bye");
                default -> System.out.println("Wrong input, pick again");
            }
        } while (!choice.equals("0"));
    }



    // TODO
    private static void showAllLocations() {
    }

    // TODO
    private static void showWeather() {
    }
}
