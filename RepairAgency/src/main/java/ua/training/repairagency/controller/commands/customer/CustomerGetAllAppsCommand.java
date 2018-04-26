package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.model.services.manager.GetAllAppsService;

public class CustomerGetAllAppsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
				
		request.setAttribute("command_result", new GetAllAppsService().execute());

		return MANAGER_PAGE;
	}

}
