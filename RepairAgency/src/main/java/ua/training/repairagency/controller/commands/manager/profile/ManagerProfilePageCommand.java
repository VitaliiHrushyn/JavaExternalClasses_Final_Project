package ua.training.repairagency.controller.commands.manager.profile;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;

public class ManagerProfilePageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		return URL.CUSTOMER_PROFILE_PAGE;
	}

}
