package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.FINISHED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.REJECTED_APPLICATION;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerShowNonactiveApplicationCommand extends AbstractShowListApplicationCommand {

	@Override
	protected String getApplicationPage() {
		return URL.MANAGER_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(REJECTED_APPLICATION, FINISHED_APPLICATION, null);
	}

	
}