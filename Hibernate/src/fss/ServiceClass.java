package fss;
 
import java.util.Set;

public class ServiceClass {
/*---------------------------------Columns---------------------------------*/
	private Integer id;
	private String name;
	private Float coeff;
	private Float cost;

	private ParticularFlight flight;

	private Set<Seat> seats;
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
	
	public Float getCoeff() {
		return coeff;
	}
	public void setCoeff(Float coeff) {
		this.coeff = coeff;
	}
	
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	public ParticularFlight getParticularFlight() {
		return flight;
	}
	public void setParticularFlight(ParticularFlight flight) {
		this.flight = flight;
	}

	public Set<Seat> getSeats() {
		return seats;
	}
	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

}