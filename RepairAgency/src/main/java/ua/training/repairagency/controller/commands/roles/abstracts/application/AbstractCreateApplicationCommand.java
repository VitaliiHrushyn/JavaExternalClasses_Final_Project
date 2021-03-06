package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.utils.ApplicationUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractCreateApplicationCommand extends AbstractCommand {
	
	Logger logger = Logger.getLogger(AbstractCreateApplicationCommand.class);

	public AbstractCreateApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		infoMessages = new ArrayList<>();
		errorMessages = new ArrayList<>();
		page = getApplicationCreatePage();
		
		if (CommandUtils.checkCreateApplication(request, errorMessages)) {
		
			try {
				serviceFactory
				.createApplicationService()
				.insert(ApplicationUtils.createNewApp(request)); 
					
				infoMessages.add(messageBundle.getString(Message.APPLICATION_CREATE_SUCCESS));
				page = getApplicationIndexPage();
			} catch (Exception e) {
				errorMessages.add(messageBundle.getString(Message.APPLICATION_CREATE_FAIL));
				page = getApplicationCreatePage();
				logger.error(Message.APPLICATION_CREATE_FAIL + e.toString() + Message.SEMICOLON);
			}			
		}		
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);		
		return page;
	}

	protected abstract String getApplicationIndexPage();
	protected abstract String getApplicationCreatePage();
	
}