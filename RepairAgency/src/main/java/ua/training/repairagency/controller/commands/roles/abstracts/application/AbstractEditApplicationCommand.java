package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.utils.ApplicationUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractEditApplicationCommand extends AbstractCommand {
	
	public AbstractEditApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		infoMessages = new ArrayList<String>();
			
		if (CommandUtils.isRequestContains(request, ID)) {
		
			Application application = serviceFactory
									.createApplicationService()
									.getById(Integer.valueOf(request.getParameter(ID)));		
		
			application = serviceFactory
					.createApplicationService()
					.update(ApplicationUtils.updateApplicationFeatures(application, request));
			
			infoMessages.add(messageBundle.getString(Message.APPLICATION_UPDATE_SUCCESS));
			request.setAttribute(APPLICATION, application);	
		}		
		
		request.setAttribute(INFO_MESSAGES, infoMessages);
		return getApplicationCommand();
	}

	protected abstract String getApplicationCommand();
	
}