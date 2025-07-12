package entity;

import jakarta.persistence.*;


@Entity
@Table(name="Countries")
public class Countries 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int country_id;

	@Column(name="country_name")
	private String country_name;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region; 

	
	public Countries() {}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}



}
