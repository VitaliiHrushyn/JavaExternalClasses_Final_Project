package ua.training.repairagency.controller.commands.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;

public abstract class AbstractShowListApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {

		
		List<Application> applications = new ArrayList<>();
		applications = getApplications(request);
					
		request.setAttribute(APPLICATIONS, applications);				
		return getApplicationPage(); 
	}
	
	protected abstract String getApplicationPage();
	protected abstract List<Application> getApplications(HttpServletRequest request);
}