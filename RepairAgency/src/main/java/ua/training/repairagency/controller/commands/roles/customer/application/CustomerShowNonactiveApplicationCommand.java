package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;

import static ua.training.repairagency.controller.constants.AttributeOrParam.FINISHED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.REJECTED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class CustomerShowNonactiveApplicationCommand extends AbstractShowListApplicationCommand {

	@Override
	protected String getApplicationPage() {
		return URL.CUSTOMER_APPLICATION_SHOW_PAGE; 
	}

	protected List<Application> getApplications(HttpServletRequest request) {
		int userId = ((User)request.getSession().getAttribute(USER)).getId();
		
		return serviceFactory
				.createApplicationService()
				.getAllByUserIdAndStatuses(String.valueOf(userId), REJECTED_APPLICATION, FINISHED_APPLICATION, null);
	}
	
}