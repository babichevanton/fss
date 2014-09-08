package springapp.fss.form;

import java.io.Serializable;

public class SearchflightForm implements Serializable {
/*---------------------------------Columns---------------------------------*/	
	private String dptr_town;
	private String dptr_time;
	private String arr_town;
	private String arr_time;
/*---------------------------------Actions---------------------------------*/	
	@Override
	public String toString() {
		return "SearchflightForm [dptr_town=" + dptr_town + ", dptr_time=" + dptr_time + ", arr_town=" + arr_town + ", arr_time=" + arr_time + "]";
	}

	public String getDptr_town() {
		return dptr_town;
	}
	public void setDptr_town(String dptr_town) {
		this.dptr_town = dptr_town;
	}

	public String getDptr_time() {
		return dptr_time;
	}
	public void setDptr_time(String dptr_town) {
		this.dptr_time = dptr_time;
	}

	public String getArr_town() {
		return arr_town;
	}
	public void setArr_town(String arr_town) {
		this.arr_town = arr_town;
	}

	public String getArr_time() {
		return arr_time;
	}
	public void setArr_time(String arr_town) {
		this.arr_time = arr_time;
	}

}
