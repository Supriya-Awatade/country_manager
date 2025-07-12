package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.HibernateUtil;
import entity.Countries;

public class CountriesService 
{
	 public void setCountry(Countries c)
	 {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
	        {
	            transaction = session.beginTransaction();
	            session.persist(c);
	            transaction.commit();
	        } 
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

	    public List<Countries> getAllCountry() 
	    {
	        try (Session session = HibernateUtil.getSessionFactory().openSession())
	        {
	            return session.createQuery("from Countries", Countries.class).list();
	        }
	    }

	    public void updateCountry(int Country_id, String Country_name) 
	    {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession())
	        {
	            transaction = session.beginTransaction();
	            Countries c1 = session.get(Countries.class, Country_id);
	            if (c1 != null) 
	            {
	                c1.setCountry_name(Country_name);
	                session.merge(c1);
	            }
	            transaction.commit();
	        } 
	        catch (Exception ee)
	        {
	            ee.printStackTrace();
	        }
	    }

	    public void deleteRegion(int country_id) 
	    {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession())
	        {
	            transaction = session.beginTransaction();
	            Countries c2 = session.get(Countries.class, country_id);
	            if (c2 != null)
	            {
	                session.remove(c2);
	            }
	            transaction.commit();
	        } 
	        catch (Exception ee) 
	        {
	            ee.printStackTrace();
	        }
	    }
}
