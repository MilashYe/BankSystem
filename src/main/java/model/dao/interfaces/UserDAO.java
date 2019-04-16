package model.dao.interfaces;

import model.dao.GenericDAO;
import model.entity.User;

public interface UserDAO extends GenericDAO<User> {


    User readByLogin(String str);
}
