package controller.listener;

import model.entity.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HashSet<String> loggedUsers = (HashSet<String>) se
            .getSession().getServletContext()
            .getAttribute("loggedUsers");
        String userName = ((User) se.getSession()
                .getAttribute("user")).getLogin();
        loggedUsers.remove(userName);
        se.getSession().setAttribute("loggedUsers", loggedUsers);
    }
}
