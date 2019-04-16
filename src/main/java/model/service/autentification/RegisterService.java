package model.service.autentification;

import model.dao.DAOFactory;
import model.dao.interfaces.UserDAO;
import model.entity.User;
import model.exception.UserExistException;

public class RegisterService {

    private UserDAO dao = DAOFactory.getInstance().createUserDAO();

    public boolean isLoginExist(String login) {
        try {
            User user = dao.readByLogin(login);
            return user.getName() != null;
        } catch (UserExistException e) {
            return false;
        }
    }

    public void createNewUser(User user) {
        dao.create(user);
    }


}
