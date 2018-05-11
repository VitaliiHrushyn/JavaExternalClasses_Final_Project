package ua.training.repairagency.controller.commands.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.controller.commands.AbstractCommand;

public abstract class AbstractShowAllApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		List<Application> applications = new ArrayList<>();
		applications = serviceFactory
				.createApplicationService()
				.getAllByUserId( ((User)request.getSession().getAttribute(USER)).getId() );
		
		request.setAttribute(APPLICATIONS, applications);				
		return getApplicationShowPage(); 
	}
	
	protected abstract String getApplicationShowPage();
	
}