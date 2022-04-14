package pl.sda.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.connection.HibernateUtil;
import pl.sda.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class LocationDAO {

    public Location findByName(String name) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Optional<Location> result = session.createQuery("FROM Location l " +
                            "WHERE l.name = :name").
                    setParameter("name", name).
                    uniqueResultOptional();

            transaction.commit();

            return result.orElse(null);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public void saveLocation(Location location) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if (findByName(location.getName()) != null) {
                System.out.println("Location with that name already exists.");
            } else {
                session.save(location);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        }
    }

    public List<Location> findAllLocations() {
        List<Location> locations = new ArrayList<>();
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            locations = session.createQuery("SELECT m FROM Location m").getResultList();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        }
        return locations;
    }

    public void deleteLocation(Location location) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(location);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e.getMessage(), e);
        }
    }
}
