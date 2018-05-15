package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.DONE_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class CustomerShowDoneApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_DONE_PATH;

	public CustomerShowDoneApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.CUSTOMER_APPLICATION_DONE_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		int userId = ((User)request.getSession().getAttribute(USER)).getId();
		
		return serviceFactory
		.createApplicationService()
		.getAllByCustomerIdAndStatuses(String.valueOf(userId), DONE_APPLICATION, null, null);
	}

}