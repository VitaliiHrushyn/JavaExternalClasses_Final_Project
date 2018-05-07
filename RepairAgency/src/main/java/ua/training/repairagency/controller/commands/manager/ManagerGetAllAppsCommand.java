package ua.training.repairagency.controller.commands.manager;

import static ua.training.repairagency.controller.constants.URL.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class ManagerGetAllAppsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
				
		request.setAttribute("command_result", null);

		return MANAGER_PAGE;
	}

}
