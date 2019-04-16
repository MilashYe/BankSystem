package controller.command.impl.pages;

import controller.command.Command;
import model.service.TimeUtil;

import javax.servlet.http.HttpServletRequest;

public class StatisticPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("times",new TimeUtil().readAllTimes());
        return "/WEB-INF/view/admin/changeTimeAdmin.jsp";
    }

}
