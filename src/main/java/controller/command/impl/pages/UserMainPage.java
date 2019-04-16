package controller.command.impl.pages;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class UserMainPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/user/mainUsr.jsp";
    }
}
