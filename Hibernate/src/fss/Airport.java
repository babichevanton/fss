package fss;

import java.util.Set;

public class Airport {
/*---------------------------------Columns---------------------------------*/
	private Integer id;
	private String name;
	private String city;
	private String phone_number;
	
	//private Set<Flight> flights_dptr;
	//private Set<Flight> flights_arr;
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
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	/*
	public Set<Flight> getFlights_dptr() {
		return flights_dptr;
	}
	public void setFlights_dptr(Set<Flight> flights_dptr) {
		this.flights_dptr = flights_dptr;
	}
	
	public Set<Flight> getFlights_arr() {
		return flights_arr;
	}
	public void setFlights_arr(Set<Flight> flights_arr) {
		this.flights_arr = flights_arr;
	}
	*/
}