package controller.command.impl.pages;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class PayBillsPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/user/payBill.jsp";
    }

}
