package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.APPROVED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EXECUTING_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.NEW_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowListApplicationCommand;

public class CustomerShowActiveApplicationCommand extends AbstractShowListApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_ACTIVE_PATH;
	private int customerId;

	public CustomerShowActiveApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationPage() {
		return URL.COMMON_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request, int pageNumber) {
		customerId = ((User)request.getSession().getAttribute(USER)).getId();
		
		return serviceFactory
				.createApplicationService()
				.getAllByCustomerIdAndStatuses(   pageNumber
												, String.valueOf(customerId)
												, NEW_APPLICATION
												, APPROVED_APPLICATION
												, EXECUTING_APPLICATION );
	}
	
	@Override
	protected String getPath() {
		return path;
	}

	@Override
	protected int getNumberOfPages() {
		return serviceFactory.createApplicationService()
							.getNumberOfPagesByQuery(     Query.APPLICATION_COUNT_BY_CUSTOMER_ID_AND_STATUSES
														, String.valueOf(customerId)
														, NEW_APPLICATION
														, APPROVED_APPLICATION
														, EXECUTING_APPLICATION);
	}

}