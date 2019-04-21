package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.TimeDao;
import model.entity.ChangeTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TimeUtil {
    private static final int ROW_PER_PAGE = 5;

    public ArrayList<ChangeTime> readAllTimes() {
        try (TimeDao dao = DAOFactory.getInstance().createTimeDAO()) {
            return sortByAccountThenDate((ArrayList<ChangeTime>) dao.readAll());
        }
    }
    public ArrayList<ChangeTime> sortByAccountThenDate(ArrayList<ChangeTime> times) {
        return (ArrayList<ChangeTime>) times.stream().
                sorted(Comparator.comparingInt(ChangeTime::getAcId).
                        thenComparing(ChangeTime::getChangeTime)).
                collect(Collectors.toList());

    }

    public ArrayList<ChangeTime> getTimeInRange(int pageNum) {
        int offset = pageNum * ROW_PER_PAGE;
        try (TimeDao dao = DAOFactory.getInstance().createTimeDAO()) {
            return (ArrayList<ChangeTime>) dao.getPage(offset, ROW_PER_PAGE);
        }
    }

    public int getPageCount() {
        try (TimeDao dao = DAOFactory.getInstance().createTimeDAO()) {
            return dao.getPageCount(ROW_PER_PAGE);
        }
    }
}
