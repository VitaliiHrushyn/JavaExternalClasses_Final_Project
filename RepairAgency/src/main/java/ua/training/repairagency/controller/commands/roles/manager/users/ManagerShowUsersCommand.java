package ua.training.repairagency.controller.commands.roles.manager.users;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

import static ua.training.repairagency.controller.constants.AttributeOrParam.USERS;
import static ua.training.repairagency.controller.constants.AttributeOrParam.NUMBER_OF_PAGES;
import static ua.training.repairagency.controller.constants.AttributeOrParam.ROLE;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class ManagerShowUsersCommand extends AbstractCommand {

	private static String path = URL.MANAGER_USERS_SHOW_PATH;

	public ManagerShowUsersCommand(Map<String, Command> commands) {
		super(path , commands);
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		
		if (CommandUtils.isRequestContainsParam(request, ROLE)) {
			
		UserRole role = UserRole.valueOf(request.getParameter(ROLE).toUpperCase());
		int pageNumber = CommandUtils.extractPageNumberFromRequest(request);
				
		List<User> users = serviceFactory
							.createUserService()
							.getAllByRoleAndPageNumber(role, pageNumber);
					
		request.setAttribute(USERS, users);
		request.setAttribute(NUMBER_OF_PAGES, getNumberOfPages(role));
		return URL.MANAGER_USERS_SHOW_PAGE; 
		
		} else {
			return URL.MANAGER_USERS_INDEX_PAGE;
		}
	}

	private Object getNumberOfPages(UserRole role) {
		return serviceFactory.createUserService()
								.getNumberOfPagesByRole(role);
	}
	
}