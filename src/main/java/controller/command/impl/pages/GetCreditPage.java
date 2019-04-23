package controller.command.impl.pages;

import controller.command.Command;
import controller.command.impl.LogoutCommand;
import model.entity.User;
import model.entity.enums.Role;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class GetCreditPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return getRedirect(request);
    }


    private String getRedirect(HttpServletRequest request) {
        User user =(User) request.getSession().getAttribute("user");

        Role role;

        if (user == null) {
            role = Role.GUEST;
        }else{
            role = Role.valueOf(user.getRole().toUpperCase());
            request.getSession().setAttribute("user",new UserUtil().readUserById(user.getId()));
        }

        if (Role.ADMIN.getRole().equals(role.getRole())) {
            new LogoutCommand().execute(request);
            return "redirect:/bank/loginpage";
        } else if (Role.USER.getRole().equals(role.getRole())) {
            return "/WEB-INF/view/user/getCredit.jsp";
        } else{
            return "/login.jsp";
        }

    }
}
