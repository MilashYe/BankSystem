package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UserInfoPageCommand implements Command {
    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public String execute(HttpServletRequest request) {
        log.info("User :" + ((User) request.getSession().getAttribute("user")).getName());
        log.info("User's accounts : " + ((User) request.getSession().getAttribute("user")).getAccounts());
        return "/WEB-INF/view/user/userInfo.jsp";
    }


}
