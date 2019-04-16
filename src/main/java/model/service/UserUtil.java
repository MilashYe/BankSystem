package model.service;

import model.dao.DAOFactory;
import model.dao.interfaces.UserDAO;
import model.entity.User;
import org.apache.log4j.Logger;

import java.util.stream.Collectors;

public class UserUtil {
    private Logger log = Logger.getLogger(this.getClass());
    public User readUserById(int id) {
        try (UserDAO dao = DAOFactory.getInstance().createUserDAO()) {
            User user = dao.readById(id);
            user = getOpenedAccount(user);
            log.info("User was read userId=" + user.getId());
            return user;
        }
    }

    public User getOpenedAccount(User user) {
        user.setAccounts(
                user.getAccounts().stream().
                        filter(account -> !account.isClosed()).
                        collect(Collectors.toList()));
        return user;
    }



}
