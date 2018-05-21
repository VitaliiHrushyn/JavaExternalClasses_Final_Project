package ua.training.repairagency.controller.commands.roles.manager.users;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

import static ua.training.repairagency.controller.constants.AttributeOrParam.USERS;
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
		
		UserRole role = UserRole.valueOf(request.getParameter(ROLE).toUpperCase());
		
		List<User> users = serviceFactory
							.createUserService()
							.getAllByRole(role);
					
		request.setAttribute(USERS, users);				
		return URL.MANAGER_USERS_SHOW_PAGE; 
	}
	
}