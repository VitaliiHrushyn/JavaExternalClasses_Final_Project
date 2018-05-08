package ua.training.repairagency.controller.utils;

import java.util.HashMap;
import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.common.*;
import ua.training.repairagency.controller.commands.customer.*;
import ua.training.repairagency.controller.commands.customer.application.*;
import ua.training.repairagency.controller.commands.customer.profile.*;
import ua.training.repairagency.controller.commands.manager.*;
import ua.training.repairagency.controller.constants.URL;

public class CommandsCreator {
	
	public static Map<String, Command> create() {
		Map<String, Command> commands = new HashMap<>();
		
		commands.put(URL.LOGOUT, new LogoutCommand());
		commands.put(URL.LOGIN, new LoginCommand());
		commands.put(URL.REGISTRATION, new RegistrationCommand());
		commands.put(URL.ERROR_404, new Error404Command());
		commands.put(URL.INDEX, new IndexPageCommand());
		
		commands.put(URL.MANAGER_PAGE_PATH, new ManagerPageCommand());
		commands.put(URL.MANAGER_MESSAGE_PATH, new ManagerMessageCommand());
		commands.put(URL.MANAGER_WORKMEN_PATH, new ManagerGetAllWorkmenCommand());
		commands.put(URL.MANAGER_APPLICATIONS_PATH, new ManagerGetAllAppsCommand());
		
	//	commands.put(URL.CUSTOMER_LOGIN_PATH, new CustomerLoginCommand());
		commands.put(URL.CUSTOMER_PROFILE_PATH, new CustomerProfilePageCommand());
		commands.put(URL.CUSTOMER_ROFILE_EDIT_PATH, new CustomerEditprofileCommand());
		commands.put(URL.CUSTOMER_PROFILE_CHANGEPASSWORD_PATH, new CustomerChangepasswordCommand());
		commands.put(URL.CUSTOMER_MESSAGE_PATH, new CustomerMessageCommand());
//		commands.put(URL.CUSTOMER_WORKMEN_PATH, new CustomerGetAllWorkmenCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_PATH, new CustomerApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_CREATE_PATH, new CustomerCreateApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_ALL_PATH, new CustomerAllApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_CURRENT_PATH, new CustomerCurrentApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_ACTIVE_PATH, new CustomerActiveApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_NONACTIVE_PATH, new CustomerNonactiveApplicationCommand());
		
		return commands;
	}

}
