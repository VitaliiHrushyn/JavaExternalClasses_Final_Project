package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.APPROVED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EXECUTING_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.RECEIVED_APPLICATION;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerShowActiveApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_ACTIVE_PATH;

	public ManagerShowActiveApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.COMMON_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request, int pageNumber) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(   pageNumber
								   , EXECUTING_APPLICATION
								   , APPROVED_APPLICATION
								   , RECEIVED_APPLICATION);
	}
	
	@Override
	protected String getPath() {
		return path;
	}
	
	@Override
	protected int getNumberOfPages() {
		return serviceFactory.createApplicationService()
							.getNumberOfPagesByQuery(     Query.APPLICATION_COUNT_BY_STATUS
														, EXECUTING_APPLICATION
														, APPROVED_APPLICATION
														, RECEIVED_APPLICATION);
	}

}