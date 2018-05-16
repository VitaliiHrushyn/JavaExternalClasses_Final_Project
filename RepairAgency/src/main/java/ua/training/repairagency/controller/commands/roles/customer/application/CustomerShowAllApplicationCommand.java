package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;
@Deprecated
public class CustomerShowAllApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_ALL_PATH;

	public CustomerShowAllApplicationCommand(Map<String, Command> commands) {
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
				.getAllByUserId(pageNumber, ((User)request.getSession().getAttribute(USER)).getId() );
	
	}
	
	@Override
	protected String getPath() {
		return path;
	}
	
}