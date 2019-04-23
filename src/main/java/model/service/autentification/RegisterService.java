package model.service.autentification;

import model.dao.DAOFactory;
import model.dao.interfaces.UserDAO;
import model.entity.User;
import model.exception.UserNoExistException;
import model.service.AccountUtil;

public class RegisterService {


    public boolean isLoginExist(String login) {

        try(UserDAO dao = DAOFactory.getInstance().createUserDAO()) {
            User user = dao.readByLogin(login);
            return user.getName() != null;
        } catch (UserNoExistException e) {
            return false;
        }
    }

    public void createNewUser(User user) {
        try (UserDAO dao = DAOFactory.getInstance().createUserDAO()) {
            dao.create(user);
            user = dao.readByLogin(user.getLogin());
            new AccountUtil().createAccount(user.getId());
        }

    }


}
