package ua.training.repairagency.controller.commands.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.controller.commands.AbstractCommand;

public abstract class AbstractShowActiveApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {

		int userId = ((User)request.getSession().getAttribute(USER)).getId();
		List<Application> applications = new ArrayList<>();
		applications = serviceFactory
				.createApplicationService()
				.getAllByUserIdAndStatuses(userId, NEW_APPLICATION, APPROVED_APPLICATION, EXECUTING_APPLICATION );
		
		request.setAttribute(APPLICATIONS, applications);				
		return getApplicationShowPage(); 
	}
	
	protected abstract String getApplicationShowPage();
}