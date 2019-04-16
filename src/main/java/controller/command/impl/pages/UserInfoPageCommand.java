package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.service.UserUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UserInfoPageCommand implements Command {
    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public String execute(HttpServletRequest request) {
        User user = ((User) request.getSession().getAttribute("user"));
        log.info("User :" + user.getName());
        log.info("User's accounts : " + ((User) request.getSession().getAttribute("user")).getAccounts());
        request.getSession().setAttribute("user",new UserUtil().readUserById(user.getId()));
        return "/WEB-INF/view/user/userInfo.jsp";
    }


}
