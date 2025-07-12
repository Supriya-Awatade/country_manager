package service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.HibernateUtil;
import entity.Region;

public class RegionService {

    public void setRegion(Region r) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(r);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Region> getAllRegion() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Region", Region.class).list();
        }
    }

    public void updateRegion(int region_id, String region_name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Region r1 = session.get(Region.class, region_id);
            if (r1 != null) {
                r1.setRegion_name(region_name);
                session.merge(r1);
            }
            transaction.commit();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void deleteRegion(int region_id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Region r2 = session.get(Region.class, region_id);
            if (r2 != null) {
                session.remove(r2);
            }
            transaction.commit();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
