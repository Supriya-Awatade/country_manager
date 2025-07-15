package service;

import java.util.List;
import java.util.Scanner;

import app.HibernateUtil;
import entity.Countries;
import entity.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CountriesService 
{
	
	Countries country = new Countries();
	Region region = new Region();
	
	public void insertCountry() throws Exception {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter Country Name: ");
	    String countryName = scanner.nextLine();

	    System.out.print("Enter Region ID for this country: ");
	    int regionId = scanner.nextInt();

	    try (EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager()) {
	        Region region = em.find(Region.class, regionId);

	        if (region == null) {
	            System.out.println("Invalid Region ID.");
	            return;
	        }

	        Countries country = new Countries();
	        country.setCountry_name(countryName);
	        country.setRegion(region);

	        saveCountry(country); // Calls persist
	    }
	}

	public void saveCountry(Countries country) throws Exception{
		EntityTransaction transaction=null;
		try(EntityManager entitymanager=HibernateUtil.getEntityManagerFactory().createEntityManager();){
			transaction=entitymanager.getTransaction();
			transaction.begin();
			entitymanager.persist(country);
			transaction.commit();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public List<Countries> getAllCountries()throws Exception{
		try(EntityManager entitymanager=HibernateUtil.getEntityManagerFactory().createEntityManager();)
		{
			return entitymanager.createQuery("from Countries",Countries.class).getResultList();
		}
	}
	
	public void updateCountry(int id, String country_name) {
		EntityTransaction transaction=null;
		try(EntityManager entitymanager=HibernateUtil.getEntityManagerFactory().createEntityManager();){
			transaction=entitymanager.getTransaction();
			transaction.begin();
			Countries con=entitymanager.find(Countries.class, id);
			if(con!=null) {
				con.setCountry_name(country_name);
				entitymanager.merge(con);
			}
			transaction.commit();
		}catch(Exception ee) {ee.printStackTrace();}
	}
	
	public void deleteCountry() {
	    EntityTransaction transaction = null;
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter the Country ID to delete: ");
	    int id = scanner.nextInt();

	    try (EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager()) {
	        transaction = entityManager.getTransaction();
	        transaction.begin();

	        Countries country = entityManager.find(Countries.class, id);
	        if (country != null) {
	            entityManager.remove(country);
	            System.out.println("Country deleted successfully.");
	        } else {
	            System.out.println("Country not found with ID: " + id);
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}

}


