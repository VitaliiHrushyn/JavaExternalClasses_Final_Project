package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.APPROVED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class WorkmanShowNewApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_NEW_PATH;

	public WorkmanShowNewApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.COMMON_APPLICATION_SHOW_TO_APPROVE_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request, int pageNumber) {
		int workmanId = ((User)request.getSession().getAttribute(USER)).getId();
		return serviceFactory
				.createApplicationService()
				.getAllByWorkmanIdAndStatuses(    pageNumber
												, String.valueOf(workmanId)
												, APPROVED_APPLICATION
												, null
												, null);
	}
	
	@Override
	protected String getPath() {
		return path;
	}
	
}