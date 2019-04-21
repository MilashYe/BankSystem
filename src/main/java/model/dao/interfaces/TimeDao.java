package model.dao.interfaces;

import model.dao.GenericDAO;
import model.entity.ChangeTime;

import java.util.List;

public interface TimeDao extends GenericDAO<ChangeTime> {
    int getPageCount(int timePerPage);

    List<ChangeTime> getPage(int offset, int length);
}
