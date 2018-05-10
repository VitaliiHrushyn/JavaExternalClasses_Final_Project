package ua.training.repairagency.controller.commands.manager.profile;

import static ua.training.repairagency.controller.constants.URL.CUSTOMER_CHANGEPASSWORD_PAGE;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class ManagerChangepasswordCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		request.setAttribute("message", "CUSTOMER CHANGE PASSWORD");

		return CUSTOMER_CHANGEPASSWORD_PAGE;
	}

}
