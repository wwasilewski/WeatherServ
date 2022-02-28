package pl.sda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sda.model.Coord;
import pl.sda.model.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public static void main(String[] args) {
        Coord coord = new Coord(50, 50);
        Location loc1 = new Location("EU", "Poland", coord);
       Location loc2 = new Location("EU", "Germany", coord);

        addLocationObjectToJSON(loc1);
        addLocationObjectToJSON(loc2);
        System.out.println(readLocationFromJSON());

    }


    public static void addLocationObjectToJSON(Location location) {
        Gson gson = new GsonBuilder().create();
        try (FileWriter writer = new FileWriter("src/main/resources/locations.json")) {
            gson.toJson(location, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location readLocationFromJSON() {
        Gson gson = new Gson();
        Location location = new Location();
        try (Reader reader = new FileReader("src/main/resources/locations.json")) {
            location = gson.fromJson(reader, Location.class);
            return location;
        } catch (IOException e ) {
            e.printStackTrace();
        }
        return location;
    }
}
