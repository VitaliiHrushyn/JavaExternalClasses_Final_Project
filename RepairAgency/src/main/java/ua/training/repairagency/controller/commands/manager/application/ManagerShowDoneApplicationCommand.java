package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.DONE_APPLICATION;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerShowDoneApplicationCommand extends AbstractShowListApplicationCommand {

	@Override
	protected String getApplicationPage() {
		return URL.MANAGER_APPLICATION_DONE_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(DONE_APPLICATION, null, null);
	}
	
}