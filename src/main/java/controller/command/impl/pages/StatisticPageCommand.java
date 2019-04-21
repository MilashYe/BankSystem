package controller.command.impl.pages;

import controller.command.Command;
import model.service.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class StatisticPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Optional<String> optionalPage = Optional.ofNullable(request.getParameter("page"));
        int pageCount = new TimeUtil().getPageCount();
        System.out.println(pageCount);
        int page = Integer.parseInt(optionalPage.orElse("0"));
        request.setAttribute("times",new TimeUtil().getTimeInRange(page));
        request.setAttribute("currentPage", page);
        request.setAttribute("pageCount", pageCount);

        return "/WEB-INF/view/admin/changeTimeAdmin.jsp";
    }

}
