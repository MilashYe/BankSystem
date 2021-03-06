package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
	@Override
	public String execute(HttpServletRequest request) {

		request.getSession().removeAttribute("user");
		return "/index.jsp";
	}
}
