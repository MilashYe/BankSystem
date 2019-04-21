package controller;

import controller.command.Command;
import controller.command.impl.LogoutCommand;
import controller.command.impl.admin.AddUserToAccountCommand;
import controller.command.impl.admin.ApproveCreditCommand;
import controller.command.impl.admin.RejectCreditCommand;
import controller.command.impl.guest.LoginSubmitCommand;
import controller.command.impl.guest.RegistrationSubmitCommand;
import controller.command.impl.pages.*;
import controller.command.impl.user.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/bank/*")
public class Servlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(Servlet.class);
	private Map<String, Command> commands = new HashMap<>();

	@Override
	public void init() throws ServletException {

		commands.put("main", new MainPageCommand());
		commands.put("registration", new RegistrationPageCommand());
		commands.put("loginpage", new LoginPageCommand());
		commands.put("deposits", new DepositsPageCommand());
		commands.put("credits", new CreditsPageCommand());
		commands.put("register", new RegistrationSubmitCommand());
		commands.put("login", new LoginSubmitCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("privateAccount", new PrivateAccountPageCommand());
		commands.put("depositPage", new GetDepositPage());
		commands.put("creditPage", new GetCreditPage());

		commands.put("user", new UserMainPage());
		commands.put("user/main", new MainPageCommand());
		commands.put("user/userMain", new UserMainPage());
		commands.put("user/userInfo", new UserInfoPageCommand());
		commands.put("user/getCredit", new GetLoanCommand());
		commands.put("user/getDeposit", new GetDepositCommand());
		commands.put("user/deposits", new DepositsPageCommand());
		commands.put("user/accountInfo", new AccountInfoCommand());
		commands.put("user/accountDelete", new AccountDeleteCommand());
		commands.put("user/deleteCredit", new DeleteCreditCommand());
		commands.put("user/deleteDeposit", new DeleteDepositCommand());
		commands.put("user/openAccount", new OpenAccountCommand());
		commands.put("user/payBillPage", new PayBillsPageCommand());
		commands.put("user/transferPage", new TransferPageCommand());
		commands.put("user/doTransfer", new TransferCommand());
		commands.put("user/payBill", new PayBillCommand());

		commands.put("admin", new AdminMainPageCommand());
		commands.put("admin/adminMain", new AdminMainPageCommand());
		commands.put("admin/main", new MainPageCommand());
		commands.put("admin/addUsers", new AddUserToAccountPage());
		commands.put("admin/statistic", new StatisticPageCommand());
		commands.put("admin/approveCreditPage", new ApproveCreditPageCommand());
		commands.put("admin/approveCredit", new ApproveCreditCommand());
		commands.put("admin/rejectCredit", new RejectCreditCommand());
		commands.put("admin/connectUser", new AddUserToAccountCommand());



	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		proccess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		proccess(req,resp);
	}

	private void proccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getRequestURI().replaceAll(".*/bank/", "");
		log.info("path:" + path);

		Command command = commands.getOrDefault(path, (r)->"/index.jsp");
		String page = command.execute(req);

		if ( page.contains("redirect") ) {
			resp.sendRedirect(req.getContextPath() + page.replaceAll("redirect:", ""));
			log.info("redirect: " + page);
		} else {
			req.getRequestDispatcher(page).forward(req, resp);
			log.info("forward: " + page);
		}


	}


}
