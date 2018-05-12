package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.NEW_APPLICATION;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class WorkmanShowNewApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_NEW_PATH;

	public WorkmanShowNewApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.WORKMAN_APPLICATION_NEW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(NEW_APPLICATION, null, null);
	}
	
}