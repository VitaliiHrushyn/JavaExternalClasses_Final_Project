package ua.training.repairagency.controller.commands;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		request.setAttribute("message", "LogOUT");

		return "/index.jsp";
	}

}
