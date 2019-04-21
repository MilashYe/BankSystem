package controller.command.impl.pages;

import controller.command.Command;
import model.entity.Credit;
import model.service.CreditUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ApproveCreditPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ArrayList<Credit> credits = new CreditUtil().getAllCredits();
        request.setAttribute("credits", credits);
        return "/WEB-INF/view/admin/approveCredits.jsp";
    }
}
