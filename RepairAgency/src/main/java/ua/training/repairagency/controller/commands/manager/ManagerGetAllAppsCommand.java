package ua.training.repairagency.controller.commands.manager;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.model.services.manager.GetAllAppsService;

public class ManagerGetAllAppsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
				
		request.setAttribute("command_result", new GetAllAppsService().execute());

		return MANAGER_PAGE;
	}

}
