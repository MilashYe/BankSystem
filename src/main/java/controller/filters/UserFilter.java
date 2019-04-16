package controller.filters;

import model.entity.User;
import model.entity.enums.Role;
import model.exception.NoAccessException;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/bank/user/*")
public class UserFilter implements Filter {

	private Logger log = Logger.getLogger(this.getClass());


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String role = getRole(req);

		log.info("role = " + role);

		if(!checkPermission(role)){
			throw new NoAccessException("You don`t have permission to visit user page");

		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

	private String getRole(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session.getAttribute("user") == null ?
				Role.GUEST.getRole() :
				((User) session.getAttribute("user")).getRole();

	}

	private boolean checkPermission(String role) {
		if (role == null){
			return false;
		}
		return role.equals("user");
	}
}
