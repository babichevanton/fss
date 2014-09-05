package fss;

import java.util.Calendar;
import java.util.Set;
 
public class ParticularFlight {
/*---------------------------------Columns---------------------------------*/
	private Integer id;
	private Calendar dptr;
	private Calendar arr;

	private Flight flight;

	private Set<ServiceClass> services;
/*---------------------------------Actions---------------------------------*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Calendar getDptr() {
		return dptr;
	}
	public void setDptr(Calendar dptr) {
		this.dptr = dptr;
	}
	
	public Calendar getArr() {
		return arr;
	}
	public void setArr(Calendar arr) {
		this.arr = arr;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Set<ServiceClass> getServices() {
		return services;
	}
	public void setServices(Set<ServiceClass> services) {
		this.services = services;
	}

}