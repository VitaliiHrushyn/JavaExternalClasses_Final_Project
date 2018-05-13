package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.application.AppStatus;

import static ua.training.repairagency.controller.constants.AttributeOrParam.COMMENT;
import static ua.training.repairagency.controller.constants.AttributeOrParam.PRICE;
import static ua.training.repairagency.controller.constants.AttributeOrParam.STATUS;
import static ua.training.repairagency.controller.constants.AttributeOrParam.WORKMAN_ID;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractEditApplicationCommand;

public class ManagerEditApplicationCommand extends AbstractEditApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_EDIT_PATH;

	public ManagerEditApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationCommand() {
		return URL.MANAGER_APPLICATION_INDEX_COMMAND;
	}
	
	@Override
	protected boolean checkParameters(HttpServletRequest request, List<String> errorMessages) {
		
		if (!CommandUtils.isRequestContainsParam(request, STATUS)) {
			return true;
		}
		System.out.println("check in method");
		System.out.println(request.getParameter(STATUS));
		System.out.println(request.getParameter(COMMENT));
		System.out.println(request.getParameter(PRICE));
		System.out.println(request.getParameter(WORKMAN_ID));

		
		String status = request.getParameter(STATUS);
		boolean check = true;
		
		if (status.equals(AppStatus.REJECTED.toString()) && !CommandUtils.isRequestContainsParam(request, COMMENT)) {
			errorMessages.add(messageBundle.getString(Message.ERROR_EMPTY_COMMENT));
			check = false;
		} 
		if (status.equals(AppStatus.RECEIVED.toString()) && !CommandUtils.isRequestContainsParam(request, PRICE)) {
			errorMessages.add(messageBundle.getString(Message.ERROR_EMPTY_PRICE));
			check = false;
		}
		if (status.equals(AppStatus.RECEIVED.toString()) && !CommandUtils.isRequestContainsParam(request, WORKMAN_ID)) {
			errorMessages.add(messageBundle.getString(Message.ERROR_EMPTY_WORKMAN));
			check = false;
		}
		return check;
	}			
	
}