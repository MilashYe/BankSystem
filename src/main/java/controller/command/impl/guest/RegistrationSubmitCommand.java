package controller.command.impl.guest;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Role;
import model.service.autentification.RegisterService;
import model.service.encryption.JBCrypt;
import model.service.encryption.PasswordService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

public class RegistrationSubmitCommand implements Command {
	private RegisterService service = new RegisterService();
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public String execute(HttpServletRequest request) {
		PasswordService pwdService = new JBCrypt();
		User user = fillUser(request);

		if (!validation(request, user)) {
			return "redirect:/bank/registration";
		}
		if (service.isLoginExist(user.getLogin())) {
			return wrongInputInform(request);
		} else {
			user.setPwdHash(pwdService.createHash(user.getPwdHash()));
			user.setRole(Role.USER);
			service.createNewUser(user);
			log.info("User was added to db, check it");
			request.getSession().setAttribute("user", user);
			return "redirect:/bank/user";
		}
	}

	private boolean checkValid(String str, String regex) {
		boolean checked = false;
		try {
			checked = str.matches(regex);
		} catch ( PatternSyntaxException e ) {
			e.printStackTrace();
		}
		return checked;

	}

	private User fillUser(HttpServletRequest request) {
		String login = request.getParameter("registrationLogin");
		String name =  request.getParameter("registrationName");
		String surname =  request.getParameter("registrationSurname");
		String phone = request.getParameter("registrationPhone");
		String pwd = request.getParameter("registrationPwd");

		request.getSession().setAttribute("login",login);
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("surname", surname);
		request.getSession().setAttribute("phone", phone);
		User user = new User();

		user.setLogin(login);
		user.setName(name);
		user.setSurname(surname);
		user.setPhone(phone);
		user.setPwdHash(pwd);

		return user;
	}

	private boolean validation(HttpServletRequest request, User user) {
		boolean submited = true;
		request.getSession().removeAttribute("alert");
		Locale locale = new Locale((String) request.getSession().getAttribute("lang"));

		if (!checkValid(user.getLogin(), ResourceBundle.getBundle("regex").getString("login.regex"))) {
			request.getSession().setAttribute("wrongLogin", ResourceBundle.getBundle("errors", locale).getString("register.login"));
			request.getSession().setAttribute("alert", true);
			submited = false;
		}
		log.info("registration user.login "+user.getLogin()+"  regex check :" + checkValid(user.getLogin(), ResourceBundle.getBundle("regex").getString("login.regex")));

		if (!checkValid(user.getName(), ResourceBundle.getBundle("regex").getString("name.regex"))) {
			request.getSession().setAttribute("wrongName", ResourceBundle.getBundle("errors", locale).getString("register.name"));
			request.getSession().setAttribute("alert", true);
			submited = false;
		}

		log.info("registration user.name "+user.getName()+"  regex check :" + checkValid(user.getName(), ResourceBundle.getBundle("regex").getString("name.regex")));

		if (!checkValid(user.getSurname(), ResourceBundle.getBundle("regex").getString("name.regex"))) {
			request.getSession().setAttribute("wrongSurname", ResourceBundle.getBundle("errors", locale).getString("register.surname"));
			request.getSession().setAttribute("alert",true);
			submited = false;
		}

		log.info("registration user.surname "+user.getSurname()+"  regex check :" + checkValid(user.getSurname(), ResourceBundle.getBundle("regex").getString("name.regex")));


		if (!checkValid(user.getPhone(), ResourceBundle.getBundle("regex").getString("mobile.phone.regex"))) {
			request.getSession().setAttribute("wrongPhone", ResourceBundle.getBundle("errors", locale).getString("register.phone"));
			request.getSession().setAttribute("alert",true);
			submited = false;
		}

		log.info("registration user.phone "+user.getPhone()+"  regex check :" + checkValid(user.getPhone(), ResourceBundle.getBundle("regex").getString("mobile.phone.regex")));

		if (!checkValid(user.getPwdHash(), ResourceBundle.getBundle("regex").getString("pwd.regex"))) {
			request.getSession().setAttribute("wrongPwd", ResourceBundle.getBundle("errors", locale).getString("register.pwd"));

			submited = false;
		}


		log.info("registration user.pwd "+user.getPwdHash()+" regex check :" + checkValid(user.getPwdHash(), ResourceBundle.getBundle("regex").getString("pwd.regex")));

		return submited;
	}

	private String wrongInputInform(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute("lang");
		String info = ResourceBundle.getBundle("errors", new Locale(lang)).getString("register.not.unique");

		request.getSession().setAttribute("info", info);
		request.getSession().setAttribute("login", null);

		log.info("info " + ResourceBundle.getBundle("errors", new Locale(lang)).getString("register.not.unique"));
		return "redirect:/bank/registration";
	}
}
