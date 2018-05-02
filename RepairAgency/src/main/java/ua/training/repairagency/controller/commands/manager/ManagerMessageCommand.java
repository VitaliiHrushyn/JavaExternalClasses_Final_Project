package ua.training.repairagency.controller.commands.manager;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class ManagerMessageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
		
		request.setAttribute("message", "message from manager message command");

		return MANAGER_PAGE;
	}

}
