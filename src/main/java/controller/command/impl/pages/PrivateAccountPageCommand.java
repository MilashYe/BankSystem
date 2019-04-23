package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Role;
import model.service.UserUtil;

import javax.servlet.http.HttpServletRequest;

public class PrivateAccountPageCommand implements Command {
	@Override
	public String execute(HttpServletRequest request) {

		return getRedirect(request);

	}

	private String getRedirect(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Role role;

		if (user == null) {
			role = Role.GUEST;
		}else{
			role = Role.valueOf(user.getRole().toUpperCase());
			user = new UserUtil().readUserById(user.getId());
			request.getSession().setAttribute("user", user);
		}


		if (Role.ADMIN.getRole().equals(role.getRole())) {
			return "redirect:/bank/admin";
		} else if (Role.USER.getRole().equals(role.getRole())) {
			return "redirect:/bank/user";
		} else{
			return "redirect:/bank/loginpage";
		}

	}
}
