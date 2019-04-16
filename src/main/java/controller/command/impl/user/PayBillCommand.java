package controller.command.impl.user;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class PayBillCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
