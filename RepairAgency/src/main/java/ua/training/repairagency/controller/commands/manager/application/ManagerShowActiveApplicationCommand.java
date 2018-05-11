package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.APPROVED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EXECUTING_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.NEW_APPLICATION;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowListApplicationCommand;

public class ManagerShowActiveApplicationCommand extends AbstractShowListApplicationCommand {

	@Override
	protected String getApplicationPage() {
		return URL.MANAGER_APPLICATION_SHOW_PAGE; 
	}

	@Override
	protected List<Application> getApplications(HttpServletRequest request) {
		return serviceFactory
				.createApplicationService()
				.getAllByStatuses(NEW_APPLICATION, APPROVED_APPLICATION, EXECUTING_APPLICATION );
	}

}