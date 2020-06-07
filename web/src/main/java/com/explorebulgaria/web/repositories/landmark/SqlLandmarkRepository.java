package com.explorebulgaria.web.repositories.landmark;

import com.explorebulgaria.web.models.Landmark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlLandmarkRepository implements  LandmarkRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Landmark getLandmarkById(int id) {
        Landmark landmark;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            landmark = session.createQuery("from Landmark where landmarkId = :id", Landmark.class)
                    .setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return landmark;
    }

    @Override
    public List<Landmark> getLandmarksByRegion(int regionId) {
        List<Landmark> landmarks;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            landmarks = session.createQuery("from Landmark where regionId = :id", Landmark.class)
                    .setParameter("id", regionId).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return landmarks;
    }

    @Override
    public void updateLandmark(int landmarkId, Landmark landmark) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Landmark landmarkToBeUpdated = session.get(Landmark.class, landmarkId);

            landmarkToBeUpdated.setIsVisited(landmark.getIsVisited());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
