package com.explorebulgaria.web.repositories.region;

import com.explorebulgaria.web.models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlRegionRepository implements RegionRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Region getRegionById(int id) {
        Region region;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            region = session.createQuery("from Region where regionId = :id", Region.class)
                    .setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return region;
    }
}
