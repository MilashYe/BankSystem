package controller.command.impl.admin;

import controller.command.Command;
import controller.command.impl.pages.ApproveCreditPageCommand;
import model.service.CreditUtil;

import javax.servlet.http.HttpServletRequest;

public class ApproveCreditCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int idCred = Integer.parseInt(request.getParameter("idCredAppr"));
        new CreditUtil().approvedCredit(idCred);
        return new ApproveCreditPageCommand().execute(request);
    }
}
