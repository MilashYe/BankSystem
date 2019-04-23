package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Role;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginPageCommand implements Command {
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public String execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		request.setAttribute("info", request.getSession().getAttribute("exception"));
		request.setAttribute("login",request.getSession().getAttribute("login"));
		request.getSession().removeAttribute("exception");
		request.getSession().removeAttribute("login");
		log.info("user : " +  user);

		return getRedirect(user);
	}

	private String getRedirect(User user) {
		Role role;
		if (user == null) {
			role = Role.GUEST;
		}else{
			role = Role.valueOf(user.getRole().toUpperCase());
		}

		if (Role.ADMIN.getRole().equals(role.getRole())) {
			return "redirect:/bank/admin";
		} else if (Role.USER.getRole().equals(role.getRole())) {
			return "redirect:/bank/user";
		} else{
			return "/login.jsp";
		}

	}
}
