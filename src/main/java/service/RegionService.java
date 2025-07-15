package service;

import java.util.List;
import java.util.Scanner;

import app.HibernateUtil;
import entity.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RegionService 
{
	
	Region region = new Region();
	public void insertRegion() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter Region Name: ");
	    String regionName = scanner.nextLine();

	    try (EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager()) {
	        List<Region> existing = em
	            .createQuery("FROM Region WHERE region_name = :name", Region.class)
	            .setParameter("name", regionName)
	            .getResultList();

	        if (!existing.isEmpty()) {
	            System.out.println("Region already exists.");
	            return;
	        }

	        Region region = new Region();
	        region.setRegion_name(regionName);

	        EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        em.persist(region);
	        tx.commit();

	        System.out.println("Region saved.");
	    }
	}

        
        public void saveRegions(Region region)throws Exception {
    		EntityTransaction transaction=null;
    		try(EntityManager entitymanager=HibernateUtil.getEntityManagerFactory().createEntityManager();){
    			transaction=entitymanager.getTransaction();
    			transaction.begin();
    			entitymanager.persist(region);
    			transaction.commit();
    		}catch(Exception e) {e.printStackTrace();}
    	}
    	
    	public List<Region> getAllRegions()throws Exception{
    		try(EntityManager entitymanage=HibernateUtil.getEntityManagerFactory().createEntityManager();){
    			return entitymanage.createQuery("from Region",Region.class).getResultList();
    		}
    	}
    	
    	public void updateRegion(int region_id,String newregion_name) throws Exception{
    		EntityTransaction transaction=null;
    		try(EntityManager entitymanager=HibernateUtil.getEntityManagerFactory().createEntityManager();){
    			transaction=entitymanager.getTransaction();
    			transaction.begin();
    			Region e=entitymanager.find(Region.class, region_id);
    			if(e!=null) {
    				e.setRegion_name(newregion_name);
    				entitymanager.merge(e);
    			}
    			transaction.commit();
    		}catch(Exception ee) {ee.printStackTrace();}
    	}
    	
    	public void deleteRegion() {
    	    EntityTransaction transaction = null;
    	    Scanner scanner = new Scanner(System.in);

    	    System.out.print("Enter the Region ID to delete: ");
    	    int regionId = scanner.nextInt();

    	    try (EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager()) {
    	        transaction = entityManager.getTransaction();
    	        transaction.begin();

    	        Region region = entityManager.find(Region.class, regionId);
    	        if (region != null) {
    	            entityManager.remove(region);
    	            System.out.println("Region deleted successfully.");
    	        } else {
    	            System.out.println("Region not found with ID: " + regionId);
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