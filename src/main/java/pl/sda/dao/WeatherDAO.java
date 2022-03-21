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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public Weather findWeatherById(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Weather weather = session.get(Weather.class, id);

            transaction.commit();

            return weather;

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();

                log.error(e.getMessage(), e);
            }
        }
        return null;
    }

    public List<Weather> findAllWeathers() {
        Transaction transaction = null;
        List<Weather> result = Collections.emptyList();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.createQuery("SELECT n FROM Weather AS n", Weather.class)
                    .getResultList();

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();

                log.error(e.getMessage(), e);
            }
        }
        return result;
    }

    public List<Weather> findWeathersByCity(String city) {
        Transaction transaction = null;
        List<Weather> result = Collections.emptyList();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.createNativeQuery("""
                            SELECT *
                            FROM weathers w
                            JOIN locations l
                            USING (location_id)
                            WHERE city_name = :name""", Weather.class)
                    .setParameter("name", city)
                    .getResultList();

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();

                log.error(e.getMessage(), e);
            }
        }
        return result;
    }


}
