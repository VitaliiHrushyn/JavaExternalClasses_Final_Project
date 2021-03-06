package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.EXECUTING_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class WorkmanShowActiveApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_ACTIVE_PATH;
	private int workmanId;

	public WorkmanShowActiveApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.COMMON_APPLICATION_DONE_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request, int pageNumber) {
		workmanId = ((User)request.getSession().getAttribute(USER)).getId();
		return serviceFactory
				.createApplicationService()
				.getAllByWorkmanIdAndStatuses(    pageNumber
												, String.valueOf(workmanId)
												, EXECUTING_APPLICATION
												, null
												, null);
	}
	
	@Override
	protected String getPath() {
		return path;
	}
	
	@Override
	protected int getNumberOfPages() {
		return serviceFactory.createApplicationService()
							.getNumberOfPagesByQuery(     Query.APPLICATION_COUNT_BY_WORKMAN_ID_AND_STATUSES
														, String.valueOf(workmanId)
														, EXECUTING_APPLICATION
														, null
														, null);
	}

}