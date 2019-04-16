package controller.command.impl.pages;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;

public class PrivateAccountPageCommand implements Command {
	@Override
	public String execute(HttpServletRequest request) {

		return getRedirect((User) request.getSession().getAttribute("user"));

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
			return "redirect:/bank/loginpage";
		}

	}
}
