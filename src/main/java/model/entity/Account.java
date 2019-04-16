package model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
	private int id;
	private long money;
	private boolean closed;
	private List<ChangeTime> changeTime = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Credit> credits = new ArrayList<>();
	private List<Deposit> deposits = new ArrayList<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public void setChangeTime(List<ChangeTime> changeTime) {
		this.changeTime = changeTime;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<ChangeTime> getChangeTime() {
		return changeTime;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public List<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return money == account.money &&
				closed == account.closed &&
				users.equals(account.users) &&
				credits.equals(account.credits) &&
				deposits.equals(account.deposits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(money, closed, changeTime, users, credits, deposits);
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", money=" + money +
				", closed=" + closed +
				", changeTime=" + changeTime +
				", users=" + users +
				", credits=" + credits +
				", deposits=" + deposits +
				'}';
	}
}
