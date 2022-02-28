package pl.sda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sda.model.Location;

import java.io.FileWriter;
import java.io.IOException;

public class JSONParser {


    public void addLocationObjectToJSON(Location location) {
        Gson gson = new GsonBuilder().create();
        try(FileWriter writer = new FileWriter("locations.json")) {
            gson.toJson(location, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
