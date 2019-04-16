package model.entity;

import model.entity.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	private int id;
	private String login;
	private Role role;
	private String pwdHash;
	private String name;
	private String surname;
	private String phone;
	private List<Account> accounts = new ArrayList<>();



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRole() {
		return role.getRole();
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return login.equals(user.login) &&
				role == user.role &&
				name.equals(user.name) &&
				surname.equals(user.surname) &&
				phone.equals(user.phone) &&
				accounts.equals(user.accounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, role, name, surname, phone, accounts);
	}

	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", role=" + role +
				", pwdHash='" + pwdHash + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", phone='" + phone + '\'' +
				", accounts=" + accounts +
				'}';
	}
}
