package springapp.fss.POJO;
 
public class Seat {
/*---------------------------------Columns---------------------------------*/
	private Integer id;
	private Short row;
	private String symb;
	private Byte status;

	private Client owner;
	private ServiceClass sclass;
/*---------------------------------Actions---------------------------------*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Short getRow() {
		return row;
	}
	public void setRow(Short row) {
		this.row = row;
	}
	
	public String getSymb() {
		return symb;
	}
	public void setSymb(String symb) {
		this.symb = symb;
	}
	
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public ServiceClass getServiceClass() {
		return sclass;
	}
	public void setServiceClass(ServiceClass sclass) {
		this.sclass = sclass;
	}

}