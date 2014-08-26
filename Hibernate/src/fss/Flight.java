package fss;
 
public class Flight {
/*---------------------------------Columns---------------------------------*/
	private Integer id;
	private String number;
	private Integer length;

	private Airline airline;
	private Airport dptr_airport;
	private Airport arr_airport;
/*---------------------------------Actions---------------------------------*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getDptr_airport() {
		return dptr_airport;
	}
	public void setDptr_airport(Airport dptr_airport) {
		this.dptr_airport = dptr_airport;
	}

	public Airport getArr_airport() {
		return arr_airport;
	}
	public void setArr_airport(Airport arr_airport) {
		this.arr_airport = arr_airport;
	}

	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
}