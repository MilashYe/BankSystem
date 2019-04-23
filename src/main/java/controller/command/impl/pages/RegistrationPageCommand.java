package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Role;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class RegistrationPageCommand implements Command {


	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public String execute(HttpServletRequest request) {
		log.info("user " + request.getSession().getAttribute("user"));

		initSessionParams(request);
		return getRedirect((User) request.getSession().getAttribute("user"));
	}

	private String getRedirect(User user) {
		Role role = Role.GUEST;
		Optional<User> optional = Optional.ofNullable(user);
		if (optional.isPresent()) {
			role = Role.valueOf(user.getRole().toUpperCase());
		}


		if (Role.ADMIN.getRole().equals(role.getRole())) {
			return "redirect:/bank/admin";
		} else if (Role.USER.getRole().equals(role.getRole())) {
			return "redirect:/bank/user";
		} else{
			return "/registration.jsp";
		}

	}
	private void initSessionParams(HttpServletRequest request) {

		request.setAttribute("info",request.getSession().getAttribute("info"));
		request.setAttribute("alert",request.getSession().getAttribute("alert"));

		request.setAttribute("login",request.getSession().getAttribute("login"));
		request.setAttribute("name", request.getSession().getAttribute("name"));
		request.setAttribute("surname", request.getSession().getAttribute("surname"));
		request.setAttribute("phone", request.getSession().getAttribute("phone"));

		request.setAttribute("wrongName", request.getSession().getAttribute("wrongName"));
		request.setAttribute("wrongLogin", request.getSession().getAttribute("wrongLogin"));
		request.setAttribute("wrongSurname", request.getSession().getAttribute("wrongSurname"));
		request.setAttribute("wrongPhone", request.getSession().getAttribute("wrongPhone"));
		request.setAttribute("wrongPwd", request.getSession().getAttribute("wrongPwd"));

		request.getSession().removeAttribute("login");
		request.getSession().removeAttribute("name");
		request.getSession().removeAttribute("surname");
		request.getSession().removeAttribute("phone");
		request.getSession().removeAttribute("info");
		request.getSession().removeAttribute("alert");
		request.getSession().removeAttribute("wrongLogin");
		request.getSession().removeAttribute("wrongName");
		request.getSession().removeAttribute("wrongSurname");
		request.getSession().removeAttribute("wrongPhone");

	}
}
