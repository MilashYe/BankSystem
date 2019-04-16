package model.entity;

import model.entity.enums.Deposits;

import java.util.Date;
import java.util.Objects;

public class Deposit  {
	private int idDep;
	private int idAcc;
	private long money;
	private int percent;
	private Deposits type;
	private long receivedMoney;
	private int endTime;
	private Date startDate;


	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
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


	public Deposits getType() {
		return type;
	}

	public void setType(Deposits type) {
		this.type = type;
	}

	public long getReceivedMoney() {
		return receivedMoney;
	}

	public void setReceivedMoney(long receivedMoney) {
		this.receivedMoney = receivedMoney;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Deposit deposit = (Deposit) o;
		return idDep == deposit.idDep &&
				money == deposit.money &&
				percent == deposit.percent &&
				receivedMoney == deposit.receivedMoney &&
				type == deposit.type &&
				startDate.equals(deposit.startDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDep, money, percent, type, receivedMoney, startDate);
	}

	@Override
	public String toString() {
		return "Deposit{" +
				"idDep=" + idDep +
				", idAcc=" + idAcc +
				", money=" + money +
				", percent=" + percent +
				", type=" + type +
				", receivedMoney=" + receivedMoney +
				", startDate=" + startDate +
				'}';
	}

	public int getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}
