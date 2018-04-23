package ua.training.repairagency.controller.commands;

import static ua.training.repairagency.controller.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class IndexCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		request.setAttribute("message", "index message");

		return INDEX_PAGE;
	}

}
