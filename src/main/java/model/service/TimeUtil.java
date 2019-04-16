package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.TimeDao;
import model.entity.ChangeTime;

import java.util.ArrayList;

public class TimeUtil {
    public ArrayList<ChangeTime> readAllTimes() {
        try (TimeDao dao = DAOFactory.getInstance().createTimeDAO()) {
            return (ArrayList<ChangeTime>) dao.readAll();
        }
    }
    // fixme
    /*public ArrayList<ChangeTime> sortByAccountThenDate(ArrayList<ChangeTime> times) {
        return times.stream().
                sorted((o1, o2) -> o1.getAcId() - o2.getAcId());

    }*/
}
