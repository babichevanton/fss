package springapp.fss.form;

import java.io.Serializable;

public class OrderSeatForm implements Serializable {
/*---------------------------------Columns---------------------------------*/	
	private String type;
	private boolean card;
	private int id;
	private String account;
/*---------------------------------Actions---------------------------------*/	
	@Override
	public String toString() {
		return "SearchflightForm [type=" + type + ", card=" + card + ", id=" + id + ", account=" + account + "]";
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean getCard() {
		return card;
	}
	public void setCard(boolean card) {
		this.card = card;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String order) {
		this.account = account;
	}

}
