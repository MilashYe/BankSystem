package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.UserDAO;
import model.entity.User;
import org.apache.log4j.Logger;

public class UserUtil {
    private Logger log = Logger.getLogger(this.getClass());
    public User readUserById(int id) {
        try (UserDAO dao = DAOFactory.getInstance().createUserDAO()) {
            User user = dao.readById(id);
            log.info("User was read userId=" + user.getId());
            return user;
        }
    }



}
