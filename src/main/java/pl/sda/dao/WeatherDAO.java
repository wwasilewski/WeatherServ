package pl.sda.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.connection.HibernateUtil;
import pl.sda.model.Weather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class WeatherDAO {

    public void save(Weather weather) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(weather);

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
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
            }
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public List<Weather> findAllWeather() {
        Transaction transaction = null;
        List<Weather> result = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.createQuery("SELECT w FROM Weather w", Weather.class).getResultList();

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        }
        return result;
    }

    public List<Weather> findWeatherByCity(String city) {
        Transaction transaction = null;
        List<Weather> result = Collections.emptyList();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            result = session.createNativeQuery("""
                            SELECT * FROM weathers JOIN locations USING (location_id)
                            WHERE name = :name""", Weather.class)
                    .setParameter("name", city)
                    .getResultList();

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        }
        return result;
    }
}
