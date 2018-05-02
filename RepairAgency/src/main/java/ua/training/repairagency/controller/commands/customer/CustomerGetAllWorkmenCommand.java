package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.PathConstants.CUSTOMER_PAGE;
import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.COMMAND_RESULT_PARAM;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.model.services.manager.GetAllWorkmenService;

public class CustomerGetAllWorkmenCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {		
		request.setAttribute(COMMAND_RESULT_PARAM, new GetAllWorkmenService().execute());
		return CUSTOMER_PAGE;
	}

}
