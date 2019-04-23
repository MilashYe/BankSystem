package controller.command.impl.admin;

import controller.command.Command;
import model.service.CreditUtil;

import javax.servlet.http.HttpServletRequest;

public class RejectCreditCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int idCred = Integer.parseInt(request.getParameter("idCredRej"));
        new CreditUtil().rejectCredit(idCred);
        return "redirect:/bank/admin/approveCreditPage";
    }
}
