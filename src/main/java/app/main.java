package app;

import java.util.List;
import java.util.Scanner;

import entity.Countries;
import entity.Region;
import service.CountriesService;
import service.RegionService;

public class main
{
    public static void main(String[] args) throws Exception
    {
    	RegionService regionService = new RegionService();
        CountriesService countryService = new CountriesService();
        Countries country = new Countries();
    	Region region = new Region();
        
    	Scanner sc=new Scanner(System.in);
    	System.out.println(".....MENU.....");
    	System.out.println("1.Add");
    	System.out.println("2.Delete");
    	System.out.println("3.update");
    	System.out.println("4.View");
    	System.out.println("5.exit");
    	
    	while(true)
    	{
    		int choice;
    	System.out.println("\nEnter your choice:");
    	choice = sc.nextInt();
        sc.nextLine(); 
    	
    	switch(choice)
    	{
    	
    	case 1:regionService.insertRegion();
    		countryService.insertCountry();
    		  
    		   break;
    		   
    	case 2:regionService.deleteRegion();
    		countryService.deleteCountry();
		   	   
		       break;
		       
    	case 3:regionService.updateRegion(region.getRegion_id(),region.getRegion_name());
    		countryService.updateCountry(country.getCountry_id(),country.getCountry_name());
		       
		       break;
		       
    	
		       
    	case 4:List<Region> re=regionService.getAllRegions();
		   for(Region r: re ) {
			System.out.println(r.getRegion_id()+" | "+r.getRegion_name());
		   }
    		
    		List<Countries> con=countryService.getAllCountries();
    		for (Countries cl : con) {
    		    Region r = cl.getRegion();
    		    String regionName = (r != null) ? r.getRegion_name() : "No Region";
    		    System.out.println(cl.getCountry_id() + " | " + cl.getCountry_name());
    		}
  break;
		   
    	case 5:System.out.println("Thank you for visiting");
    	sc.close();
    			break;
    			
    	default:System.out.println("Invalid choice");
    			break;
		
    	
    	}
    
    }	
    		
	            	
	            	
	            
    
    		}
    	}
    

