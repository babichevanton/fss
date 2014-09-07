package springapp.fss.pojo;

import java.util.Set;

public class Airline {
/*---------------------------------Columns---------------------------------*/	
	private Integer id;
	private String name;
	
	private Set<Flight> flights;
	private Set<Bonus> bonuses;
/*---------------------------------Actions---------------------------------*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public Set<Bonus> getBonuses() {
		return bonuses;
	}
	public void setBonuses(Set<Bonus> bonuses) {
		this.bonuses = bonuses;
	}

}