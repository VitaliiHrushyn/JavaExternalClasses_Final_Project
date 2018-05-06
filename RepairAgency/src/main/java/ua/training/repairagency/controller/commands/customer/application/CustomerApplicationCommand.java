package ua.training.repairagency.controller.commands.customer.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;

public class CustomerApplicationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		request.setAttribute(COMMAND_RESULT, "customer app index page");
				
		return URL.CUSTOMER_APPLICATION_INDEX_PAGE;
	}

}
