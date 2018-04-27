package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		
//		request.setAttribute("message", "Loged OUT");

		return REDIRECT_LOGIN_COMMAND;
	}

}
