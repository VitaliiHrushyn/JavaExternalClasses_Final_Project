package ua.training.repairagency.controller.commands.customer.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.controller.commands.AbstractCommand;

public class CustomerNonactiveApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		List<Application> applications = new ArrayList<>();
		applications = serviceFactory
				.createApplicationService()
				.getAllByUserId( ((User)request.getSession().getAttribute(USER)).getId() );
		
		request.setAttribute(APPLICATIONS, applications);				
		return URL.CUSTOMER_APPLICATION_ALL_PAGE; 
	}
}