package model.entity;

import java.util.Date;
import java.util.Objects;

public class ChangeTime {
    private int idTime;
    private Date changeTime;
    private int acId;
    private String message;

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeTime time = (ChangeTime) o;
        return acId == time.acId &&
                changeTime.equals(time.changeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changeTime, acId);
    }

    @Override
    public String toString() {
        return "ChangeTime{" +
                "idTime=" + idTime +
                ", changeTime=" + changeTime +
                ", acId=" + acId +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
