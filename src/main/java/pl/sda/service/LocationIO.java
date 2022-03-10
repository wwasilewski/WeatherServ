package pl.sda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sda.model.Location;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocationIO {


    static Gson gson = new Gson();
    static final String FILE_PATH = "src/main/resources/locations.json";

    public static void addLocationObjectToJSON(Location location) {
        try {
            Files.write(Paths.get(FILE_PATH), (gson.toJson(location) + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLocationFromJSON() {
        try(Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
}
