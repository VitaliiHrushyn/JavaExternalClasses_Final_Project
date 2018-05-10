package ua.training.repairagency.controller.commands.customer.testimonial;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;

public class CustomerProfilePageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		return URL.CUSTOMER_PROFILE_PAGE;
	}

}
