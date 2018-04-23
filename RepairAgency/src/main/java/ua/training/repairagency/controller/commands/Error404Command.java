package ua.training.repairagency.controller.commands;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import static ua.training.repairagency.controller.commands.CommandConstants.*;

public class Error404Command implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		request.setAttribute("message", "message from 404 command");

		return PAGE_404;
	}

}
