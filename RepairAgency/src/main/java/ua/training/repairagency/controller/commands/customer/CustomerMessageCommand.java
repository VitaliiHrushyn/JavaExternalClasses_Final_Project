package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.URL.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class CustomerMessageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
		
		request.setAttribute("message", "message from CUSTOMER message command");

		return CUSTOMER_MESSAGE_PAGE;
	}

}
