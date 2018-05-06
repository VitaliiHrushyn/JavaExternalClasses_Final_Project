package ua.training.repairagency.controller.commands.customer;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;

public class CustomerApplicationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
				
//		request.setAttribute("command_result", new GetAllAppsService().execute());

		return URL.CUSTOMER_APPLICATION_PAGE;
	}

}
