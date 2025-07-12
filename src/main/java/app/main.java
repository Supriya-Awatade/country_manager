package app;

import java.util.List;

import entity.Countries;
import entity.Region;
import service.CountriesService;
import service.RegionService;

public class main {
    public static void main(String[] args) {
        RegionService regionService = new RegionService();
        CountriesService countryService = new CountriesService();

        // Create and persist region
        Region region = new Region();
        region.setRegion_name("South Region");
        regionService.setRegion(region); // Persist first so ID is generated

        // Create and persist country associated with region
        Countries country = new Countries();
        country.setCountry_name("India");
        country.setRegion(region); // Set relationship
        countryService.setCountry(country);

        // Fetch and print all regions
        List<Region> regList = regionService.getAllRegion();
        for (Region rl : regList) {
            System.out.println(rl.getRegion_id() + " - " + rl.getRegion_name());
        }

        // Fetch and print all countries
        List<Countries> counList = countryService.getAllCountry();
        for (Countries cl : counList) {
            System.out.println(cl.getCountry_id() + " - " + cl.getCountry_name() +
                               " (Region: " + cl.getRegion().getRegion_name() + ")");
        }
    }
}
