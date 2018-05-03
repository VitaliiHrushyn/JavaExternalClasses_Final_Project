package ua.training.repairagency.controller.commands.customer;

import static ua.training.repairagency.controller.constants.URL.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class CustomerPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
		
		request.setAttribute("message", "CUSTOMER index message");

		return CUSTOMER_PAGE;
	}

}
