package ua.training.repairagency.controller.commands.manager;

import static ua.training.repairagency.controller.constants.URL.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class ManagerPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
		
		request.setAttribute("message", "manager index message");

		return MANAGER_PAGE;
	}

}
