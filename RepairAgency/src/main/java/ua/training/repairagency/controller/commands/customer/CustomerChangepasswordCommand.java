package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.URL.CUSTOMER_CHANGEPASSWORD_PAGE;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class CustomerChangepasswordCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		request.setAttribute("message", "CUSTOMER CHANGE PASSWORD");

		return CUSTOMER_CHANGEPASSWORD_PAGE;
	}

}
