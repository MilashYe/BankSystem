package controller.command.impl.guest;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Role;
import model.service.autentification.LoginService;
import model.service.encryption.JBCrypt;
import model.service.encryption.PasswordService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginSubmitCommand implements Command {
	private Logger log = Logger.getLogger(this.getClass());
	private LoginService service = new LoginService();
	@Override
	public String execute(HttpServletRequest request) {

		String login = request.getParameter("login");
		String pwd = request.getParameter("password");

		if (!service.isUserExist(login)) {
			return userNotExist(request);
		}
		User user = service.readUser(login);
		log.info("User from DB in login page :" + user);

		PasswordService pwdService = new JBCrypt();
		boolean check = pwdService.checkPwd(pwd, user.getPwdHash());
		log.info("Login check: " + check);
		if(check){
			request.getSession().setAttribute("user",user);
			return getRedirect(user);
		}else {
			String lang = (String) request.getSession().getAttribute("lang");
			String info = ResourceBundle.getBundle("errors", new Locale(lang)).getString("register.pwd");
			request.getSession().setAttribute("exception", info);
			request.getSession().setAttribute("login",login);
			request.getSession().setAttribute("wrongPass", "");
			log.info("info wrong pwd "+info);
			return "redirect:/bank/loginpage";
		}

	}

	private String userNotExist(HttpServletRequest request) {

		String lang = (String) request.getSession().getAttribute("lang");
		String info = ResourceBundle.getBundle("errors", new Locale(lang)).getString("login.not.exist");

		request.getSession().setAttribute("exception", info);
		log.info("info user not exist "+info);
		return "redirect:/bank/loginpage";
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
