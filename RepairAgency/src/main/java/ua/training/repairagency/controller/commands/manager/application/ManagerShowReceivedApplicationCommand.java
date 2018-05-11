package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.RECEIVED_APPLICATION;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerShowReceivedApplicationCommand extends AbstractShowListApplicationCommand {

	@Override
	protected String getApplicationPage() {
		return URL.MANAGER_APPLICATION_RECEIVED_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(RECEIVED_APPLICATION, null, null);
	}
	
}