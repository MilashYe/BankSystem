package model.service.autentification;

import model.dao.DAOFactory;
import model.dao.interfaces.UserDAO;
import model.entity.User;
import model.exception.UserNoExistException;

import java.util.logging.Logger;


public class LoginService {
    private Logger logger = Logger.getLogger(LoginService.class.getName());
    private UserDAO dao = DAOFactory.getInstance().createUserDAO();

    public boolean isUserExist(String login) {
        try {
            User user = dao.readByLogin(login);
            logger.info("user exist in login service login");
            return true;
        } catch (UserNoExistException ex) {
            logger.info("user not exist in login service login");

            return false;
        }
    }

    public User readUser(String login) {
        return dao.readByLogin(login);
    }
}
