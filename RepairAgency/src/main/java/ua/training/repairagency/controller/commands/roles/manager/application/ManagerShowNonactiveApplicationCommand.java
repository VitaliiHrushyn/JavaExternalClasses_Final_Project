package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerShowNonactiveApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_NONACTIVE_PATH;

	public ManagerShowNonactiveApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.COMMON_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(DONE_APPLICATION, REJECTED_APPLICATION, FINISHED_APPLICATION);
	}

	
}