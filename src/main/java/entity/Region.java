package entity;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="Region")
public class Region 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int region_id;

	@Column(name="region_name")
	private String region_name;
	
	@OneToMany(mappedBy = "region")
    private List<Countries> countries;
	
	public Region() {}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	 

}
