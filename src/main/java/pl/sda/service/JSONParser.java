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
        Location loc1 = new Location("Warszawa","EU", "Poland", coord);
       Location loc2 = new Location("Berlin", "EU", "Germany", coord);

        addLocationObjectToJSON(loc1);
       // addLocationObjectToJSON(loc2);
        System.out.println(readLocationFromJSON());

    }

    static Gson gson = new Gson();
    static final String FILE_PATH = "src/main/resources/locations.json";

    public static void addLocationObjectToJSON(Location location) {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            writer.println(gson.toJson(location));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location readLocationFromJSON() {
        Location location = new Location();
        try (Reader reader = new FileReader(FILE_PATH)) {
            location = gson.fromJson(reader, Location.class);
            return location;
        } catch (IOException e ) {
            e.printStackTrace();
        }
        return location;
    }
}
