package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.URL.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.model.services.manager.GetAllAppsService;

public class CustomerGetAllAppsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
				
		request.setAttribute("command_result", new GetAllAppsService().execute());

		return CUSTOMER_PAGE;
	}

}
