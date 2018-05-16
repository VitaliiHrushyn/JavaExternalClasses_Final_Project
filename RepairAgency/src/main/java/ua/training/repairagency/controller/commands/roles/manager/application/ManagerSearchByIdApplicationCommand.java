package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerSearchByIdApplicationCommand extends AbstractShowListApplicationCommand {
	
	private static String path = URL.MANAGER_APPLICATIONS_SEARCH_BY_ID_PATH;
	
	public ManagerSearchByIdApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.COMMON_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request, int pageNumber) {
		List<Application> applications = new ArrayList<>();
		if (CommandUtils.isRequestContainsParam(request, ID)) {
				applications.add(serviceFactory
							.createApplicationService()
							.getById(Integer.valueOf(request.getParameter(ID))));
		}
		return applications;
	}
	
	@Override
	protected String getPath() {
		return path;
	}
	
}