package pl.sda.controller;

import pl.sda.dto.LocationDto;
import pl.sda.service.LocationService;

import java.util.Scanner;

public class LocationController {
    private static Scanner sc = new Scanner(System.in);
    private static final LocationService locationService = new LocationService();


    public static LocationDto insertLocation() {
        String name = getName();
        String region = getRegion();
        String country = getCountry();
        float longitude = getLongitude();
        float latitude = getLatitude();
        sc.nextLine();
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
        if(name.isBlank()) {
            System.out.println("The name of the location can not be empty.");
            getName();
        }
        return name;
    }

    private static String getRegion() {
        System.out.println("Please enter the name of the region of the location: ");
        String region = sc.nextLine();
        return region;
    }

    private static String getCountry() {
        System.out.println("Please enter the name of the country: ");
        String country = sc.nextLine();
        if(country.isBlank()) {
            System.out.println("The country field can not be empty.");
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
                getLongitude();
            }
            return longitude;
        } catch (NumberFormatException ignored) {}
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
                getLatitude();
            }
            return latitude;
        } catch (NumberFormatException ignored) {}
        return getLatitude();
    }
}
