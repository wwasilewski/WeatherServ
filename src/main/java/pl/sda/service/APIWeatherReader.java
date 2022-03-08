package pl.sda.service;

import pl.sda.model.DateWeather;
import pl.sda.model.Location;
import java.io.IOException;
import java.net.URISyntaxException;


interface APIWeatherReader {

    String createAPICall(Location location);

    DateWeather readWeather(Location location) throws URISyntaxException, IOException, InterruptedException;
}










