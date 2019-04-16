package model.entity;

import model.entity.enums.Credits;

import java.util.Objects;

public class Credit {
	private int idCred;
	private int account;
	private long money;
	private int percent;
	private Credits type;
	private int termToClose;
	private boolean approved;
	private boolean rejected;


	public int getIdCred() {
		return idCred;
	}

	public void setIdCred(int idCred) {
		this.idCred = idCred;
	}


	public long getMoney() {
		return money;
	}


	public void setMoney(long money) {
		this.money = money;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public Credits getType() {
		return type;
	}

	public void setType(Credits type) {
		this.type = type;
	}

	public int getTermToClose() {
		return termToClose;
	}

	public void setTermToClose(int termToClose) {
		this.termToClose = termToClose;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Credit credit = (Credit) o;
		return money == credit.money &&
				percent == credit.percent &&
				termToClose == credit.termToClose &&
				approved == credit.approved &&
				rejected == credit.rejected &&
				type == credit.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money, percent, type, termToClose, approved, rejected);
	}

	@Override
	public String toString() {
		return "Credit{" +
				"idCred=" + idCred +
				", account=" + account +
				", money=" + money +
				", percent=" + percent +
				", type=" + type +
				", termToClose=" + termToClose +
				", approved=" + approved +
				", rejected=" + rejected +
				'}';
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
}
