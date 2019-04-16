package controller.command.impl.user;

import controller.command.Command;
import controller.command.impl.pages.UserInfoPageCommand;
import model.service.AccountUtil;

import javax.servlet.http.HttpServletRequest;

public class AccountDeleteCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        proccess(request);
        return new UserInfoPageCommand().execute(request);
    }

    private void proccess(HttpServletRequest request) {
        int accId = Integer.parseInt(request.getParameter("acId"));
        new AccountUtil().setClosedAccountById(accId);
/*
        User user = new UserUtil().updateUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user",user);*/
    }
}
