package com.explorebulgaria.web.repositories.region;

import com.explorebulgaria.web.models.Landmark;
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

    @Override
    public void updateRegion(int regionId, Region region) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Region regionToBeUpdated = session.get(Region.class, regionId);

            //regionToBeUpdated.setRegionIsVisited(region.isRegionVisited());

            boolean isRegionVisited = regionToBeUpdated.isRegionVisited();

            if(isRegionVisited) {
                regionToBeUpdated.setRegionIsVisited(false);
            } else {
                regionToBeUpdated.setRegionIsVisited(true);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
