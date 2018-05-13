package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.exceptions.OutOfDateDataException;
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
		errorMessages = new ArrayList<>();
			
		if (CommandUtils.isRequestContainsParam(request, ID)) {
		
			Application application = serviceFactory
									.createApplicationService()
									.getById(Integer.valueOf(request.getParameter(ID)));
		
			try {
				application = serviceFactory
						.createApplicationService()
						.update(ApplicationUtils.updateApplicationFeatures(application, request));
				infoMessages.add(messageBundle.getString(Message.APPLICATION_UPDATE_SUCCESS));
				
			} catch (OutOfDateDataException e) {
//TODO add logging
				e.printStackTrace();
				errorMessages.add(messageBundle.getString(Message.APPLICATION_OUT_OF_DATE));
			}			
			
			request.setAttribute(APPLICATION, application);	
		}		
		
		request.setAttribute(INFO_MESSAGES, infoMessages);
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		return getApplicationCommand();
	}

	protected abstract String getApplicationCommand();
	
}