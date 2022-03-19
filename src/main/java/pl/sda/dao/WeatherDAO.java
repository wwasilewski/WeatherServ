package pl.sda.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.connection.HibernateUtil;
import pl.sda.mapper.OpenWeatherObjectToWeatherMapper;
import pl.sda.model.Location;
import pl.sda.model.Weather;
import pl.sda.model.openWeatherAPI.OpenWeatherObject;
import pl.sda.service.OpenWeatherReader;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class WeatherDAO {

    public void saveWeather(Weather weather, Location location) {
        //weather.setLocation(location);


        // tutaj logika Hibernate związana z zapisem  Weather
    }

    public void save(Location location, int dayOfForecast) throws URISyntaxException, IOException, InterruptedException {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            OpenWeatherReader openWeatherReader = new OpenWeatherReader();
            OpenWeatherObject openWeatherObject = openWeatherReader.readWeather(location);

            Weather weather = OpenWeatherObjectToWeatherMapper.readWeatherForSpecificDay(openWeatherObject, dayOfForecast);
            weather.setLocation(location);

            session.save(weather);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();

                log.error(e.getMessage(), e);
            }
        }
    }
}


