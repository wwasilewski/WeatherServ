package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import pl.sda.dto.LocationDto;
import pl.sda.service.LocationService;
import pl.sda.view.UserInterface;

import java.util.Scanner;

@Slf4j
public class LocationController {

    private static final Scanner sc = new Scanner(System.in);
    private static final LocationService locationService = new LocationService();

    public static LocationDto insertLocation() {
        String name = getName();
        String region = getRegion();
        String country = getCountry();
        float longitude = getLongitude();
        float latitude = getLatitude();

        LocationDto result = new LocationDto();
        result.setName(name);
        result.setRegion(region);
        result.setCountry(country);
        result.setLongitude(longitude);
        result.setLatitude(latitude);
        return result;
    }

    public void addLocation() {
        LocationDto input = insertLocation();
        locationService.addLocation(input);
    }

    private static String getName() {
        System.out.println("Please enter the name of the location to add: ");
        String name = sc.nextLine();

        if (name.isBlank()) {
            System.out.println("The name of the location can not be empty.");
            backToMenu();
            getName();
        }
        return name;
    }

    private static String getRegion() {
        System.out.println("Please enter the name of the region: ");
        return sc.nextLine();
    }

    private static String getCountry() {
        System.out.println("Please enter the name of the country: ");
        String country = sc.nextLine();

        if (country.isBlank()) {
            System.out.println("The country field can not be empty.");
            backToMenu();
            getCountry();
        }
        return country;
    }

    private static float getLongitude() {
        System.out.println("Please enter the longitude of the location. \n" +
                "Use positive numbers [0 - 180] for East " +
                "values and negative [-180 - 0] for West values.");
        try {
            float longitude = Float.parseFloat(sc.nextLine());

            if (longitude < -180 || longitude > 180) {
                System.out.println("Please enter the number from the given range: from -180(for West) to 180(for East)");
                backToMenu();
                getLongitude();
            }
            return longitude;
        } catch (NumberFormatException e) {
            log.warn(e.getMessage(), e);
        }
        return getLongitude();
    }

    private static float getLatitude() {
        System.out.println("Please enter the latitude of the location. \n" +
                "Use positive numbers [0 - 90] for North " +
                "values and negative [-90 - 0] for South values.");
        try {
            float latitude = Float.parseFloat(sc.nextLine());

            if (latitude < -90 || latitude > 90) {
                System.out.println("Please enter the number from the given range: from -90(for South) to 90(for North)");
                backToMenu();
                getLatitude();
            }
            return latitude;
        } catch (NumberFormatException e) {
            log.warn(e.getMessage(), e);
        }
        return getLatitude();
    }

    public void showAllLocations() {
        locationService.findAllLocations()
                .stream()
                .map(LocationController::printLocationDto)
                .forEach(System.out::println);
    }

    private static String printLocationDto(LocationDto locationDto) {
        return "\nLocation: " + locationDto.getName()
                + "\nRegion: " + locationDto.getRegion()
                + "\nCountry: " + locationDto.getCountry()
                + "\nCoordinates:\n\t- longitude: " + locationDto.getLongitude()
                + "\n\t- latitude: " + locationDto.getLatitude()
                + "\n_______________________________________________";
    }

    private static void backToMenu() {
        System.out.println("Write 'exit' for going back to main menu.");
        String input = sc.nextLine();
        if (input.equals("exit")) {
            UserInterface.showMenu();
        }
    }
}
