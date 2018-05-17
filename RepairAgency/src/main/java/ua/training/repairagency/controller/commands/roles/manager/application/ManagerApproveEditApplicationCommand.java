package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.exceptions.OutOfDateDataException;
import ua.training.repairagency.model.utils.ApplicationUtils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class ManagerApproveEditApplicationCommand extends AbstractCommand {

	private static String path = URL.MANAGER_APPLICATIONS_APPROVE_PATH;

	public ManagerApproveEditApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}
	
	@Override
	public String execute(HttpServletRequest request) {
				
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		infoMessages = new ArrayList<String>();
		errorMessages = new ArrayList<>();
		
		List<User> workmen = serviceFactory
 				.createUserService()
 				.getAllByRole(UserRole.WORKMAN);
		
		if (CommandUtils.isRequestContainsParam(request, ID)) {

			 Application application = serviceFactory
					 					.createApplicationService()
					 					.getById(Integer.valueOf(request.getParameter(ID)));
			
			request.setAttribute(APPLICATION, application);
			request.setAttribute(WORKMEN, workmen);
			return URL.MANAGER_APPLICATION_APPROVE_PAGE;
		}
		
		Application application = CommandUtils.getApplicationFromRequest(request);

		if (checkEditingParameters(request, errorMessages)) {
			
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
			
			request.setAttribute(INFO_MESSAGES, infoMessages);
			request.setAttribute(ERROR_MESSAGES, errorMessages);
			return URL.MANAGER_APPLICATION_NEW_COMMAND;
			
		} else {		
			request.setAttribute(APPLICATION, application);
			request.setAttribute(WORKMEN, workmen);
			request.setAttribute(ERROR_MESSAGES, errorMessages);
			return URL.MANAGER_APPLICATION_APPROVE_PAGE;					
		}  
			
	}
	
	private boolean checkEditingParameters(HttpServletRequest request, List<String> errorMessages) {
		String status = request.getParameter(STATUS);
		boolean check = true;
		
		if (status.equals(AppStatus.REJECTED.toString()) 
				&& !CommandUtils.isRequestContainsParam(request, COMMENT)) {
			errorMessages.add(messageBundle.getString(Message.ERROR_EMPTY_COMMENT));
			check = false;
		} 
		if (status.equals(AppStatus.RECEIVED.toString()) 
				&& 	(    !CommandUtils.isRequestContainsParam(request, PRICE)
					  || !CommandUtils.isRequestContainsParam(request, WORKMAN_ID) )
			) {
			errorMessages.add(messageBundle.getString(Message.ERROR_EMPTY_PRICE_OR_WORKMAN));
			check = false;
		}
		
		return check;
	}			
	
}