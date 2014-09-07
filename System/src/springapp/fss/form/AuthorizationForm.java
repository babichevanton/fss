package springapp.fss.form;

import java.io.Serializable;

public class AuthorizationForm implements Serializable {
/*---------------------------------Columns---------------------------------*/	
	private String login;
	private String password;
/*---------------------------------Actions---------------------------------*/	
	@Override
	public String toString() {
		return "AuthorizationForm [login=" + login + ", password=" + password + "]";
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
