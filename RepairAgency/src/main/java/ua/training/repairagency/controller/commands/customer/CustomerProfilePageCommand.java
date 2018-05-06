package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;

public class CustomerProfilePageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
	//	request.setAttribute(USER, request.getSession().getAttribute(USER));

		return URL.CUSTOMER_PROFILE_PAGE;
	}

}
