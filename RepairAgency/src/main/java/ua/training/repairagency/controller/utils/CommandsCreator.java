package ua.training.repairagency.controller.utils;

import java.util.HashMap;
import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.common.*;
import ua.training.repairagency.controller.commands.customer.*;
import ua.training.repairagency.controller.commands.customer.application.*;
import ua.training.repairagency.controller.commands.customer.profile.*;
import ua.training.repairagency.controller.commands.manager.*;
import ua.training.repairagency.controller.commands.manager.application.ManagerApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerApproveApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerCreateApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerEditApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerFinishApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerShowActiveApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerShowAllApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerShowDoneApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerShowNonactiveApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerShowOneApplicationCommand;
import ua.training.repairagency.controller.commands.manager.application.ManagerShowNewApplicationCommand;
import ua.training.repairagency.controller.commands.manager.profile.ManagerEditprofileCommand;
import ua.training.repairagency.controller.commands.manager.profile.ManagerProfilePageCommand;
import ua.training.repairagency.controller.constants.URL;

public class CommandsCreator {
	
	public static Map<String, Command> create() {
		Map<String, Command> commands = new HashMap<>();
		
		commands.put(URL.LOGOUT, new LogoutCommand());
		commands.put(URL.LOGIN, new LoginCommand());
		commands.put(URL.REGISTRATION, new RegistrationCommand());
		commands.put(URL.ERROR_404, new Error404Command());
		commands.put(URL.INDEX, new IndexPageCommand());
		

		
		commands.put(URL.CUSTOMER_PROFILE_PATH, new CustomerProfilePageCommand());
		commands.put(URL.CUSTOMER_ROFILE_EDIT_PATH, new CustomerEditprofileCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_PATH, new CustomerApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_CREATE_PATH, new CustomerCreateApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_ALL_PATH, new CustomerShowAllApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_ONE_PATH, new CustomerShowOneApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_DONE_PATH, new CustomerShowDoneApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_FINISH_PATH, new CustomerFinishApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_EDIT_PATH, new CustomerEditApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_CURRENT_PATH, new CustomerShowDoneApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_RECEIVED_PATH, new CustomerShowReceivedApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_APPROVE_PATH, new CustomerApproveApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_ACTIVE_PATH, new CustomerShowActiveApplicationCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_NONACTIVE_PATH, new CustomerShowNonactiveApplicationCommand());
		
		commands.put(URL.MANAGER_PROFILE_PATH, new ManagerProfilePageCommand());
		commands.put(URL.MANAGER_ROFILE_EDIT_PATH, new ManagerEditprofileCommand());
		commands.put(URL.MANAGER_APPLICATIONS_PATH, new ManagerApplicationCommand());
//		commands.put(URL.MANAGER_APPLICATIONS_CREATE_PATH, new ManagerCreateApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_ALL_PATH, new ManagerShowAllApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_ONE_PATH, new ManagerShowOneApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_DONE_PATH, new ManagerShowDoneApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_FINISH_PATH, new ManagerFinishApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_EDIT_PATH, new ManagerEditApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_CURRENT_PATH, new ManagerShowDoneApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_NEW_PATH, new ManagerShowNewApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_APPROVE_PATH, new ManagerApproveApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_ACTIVE_PATH, new ManagerShowActiveApplicationCommand());
		commands.put(URL.MANAGER_APPLICATIONS_NONACTIVE_PATH, new ManagerShowNonactiveApplicationCommand());
		
		return commands;
	}

}
