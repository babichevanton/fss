package springapp.fss.form;

import java.io.Serializable;

public class RegistrationForm implements Serializable {
/*---------------------------------Columns---------------------------------*/	
	private String login;
	private String password;
	private String name;
	private String patronymic;
	private String surname;
	private String address;
	private String phone;
	private String email;
/*---------------------------------Actions---------------------------------*/	
	@Override
	public String toString() {
		return "ARegistrationForm [login=" + login + ", password=" + password + ", name=" + name + ", patronymic=" + patronymic + 
				", surname=" + surname + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
