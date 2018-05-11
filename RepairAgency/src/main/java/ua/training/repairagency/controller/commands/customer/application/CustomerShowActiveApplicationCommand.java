package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.APPROVED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EXECUTING_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.NEW_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class CustomerShowActiveApplicationCommand extends AbstractShowListApplicationCommand {

	@Override
	protected String getApplicationPage() {
		return URL.CUSTOMER_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		int userId = ((User)request.getSession().getAttribute(USER)).getId();
		
		return serviceFactory
				.createApplicationService()
				.getAllByUserIdAndStatuses(String.valueOf(userId), NEW_APPLICATION, APPROVED_APPLICATION, EXECUTING_APPLICATION );
	}

}