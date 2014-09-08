package springapp.fss.form;

import java.io.Serializable;

public class SearchClientForm implements Serializable {
/*---------------------------------Columns---------------------------------*/	
	private String number;
	private String airline;
	private String dptr_city;
	private String arr_city;
	private String dptr_time;
	private String arr_time;
	private boolean ordered;
	private boolean reserved;
/*---------------------------------Actions---------------------------------*/	
	@Override
	public String toString() {
		return "SearchClientForm [number=" + number + ", airline=" + airline + ", dptr_city=" + dptr_city + ", arr_city=" + arr_city + 
		", dptr_time=" + dptr_time + ", arr_time=" + arr_time + ", ordered=" + ordered + ", reserved=" + reserved + "]";
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDptr_city() {
		return dptr_city;
	}
	public void setDptr_city(String dptr_city) {
		this.dptr_city = dptr_city;
	}

	public String getDptr_time() {
		return dptr_time;
	}
	public void setDptr_time(String dptr_city) {
		this.dptr_time = dptr_time;
	}

	public String getArr_city() {
		return arr_city;
	}
	public void setArr_city(String arr_city) {
		this.arr_city = arr_city;
	}

	public String getArr_time() {
		return arr_time;
	}
	public void setArr_time(String arr_city) {
		this.arr_time = arr_time;
	}

	public boolean getOrdered() {
		return ordered;
	}
	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public boolean getReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

}
