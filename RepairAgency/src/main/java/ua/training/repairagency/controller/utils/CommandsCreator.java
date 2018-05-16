package ua.training.repairagency.controller.utils;

import java.util.HashMap;
import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.common.*;
import ua.training.repairagency.controller.commands.roles.customer.application.*;
import ua.training.repairagency.controller.commands.roles.customer.profile.*;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerApproveEditApplicationCommand;
//import ua.training.repairagency.controller.commands.roles.manager.application.ManagerCreateApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerEditApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerFinishApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerSearchByIdApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerShowActiveApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerShowAllApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerShowDoneApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerShowNewApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerShowNonactiveApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.application.ManagerShowOneApplicationCommand;
import ua.training.repairagency.controller.commands.roles.manager.profile.ManagerEditprofileCommand;
import ua.training.repairagency.controller.commands.roles.manager.profile.ManagerProfilePageCommand;
import ua.training.repairagency.controller.commands.roles.manager.users.ManagerCreateUserCommand;
import ua.training.repairagency.controller.commands.roles.manager.users.ManagerDeleteUserCommand;
import ua.training.repairagency.controller.commands.roles.manager.users.ManagerEditUserCommand;
import ua.training.repairagency.controller.commands.roles.manager.users.ManagerShowUsersCommand;
import ua.training.repairagency.controller.commands.roles.manager.users.ManagerUsersCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanApproveApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanEditApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanFinishApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanShowActiveApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanShowNewApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanShowNonactiveApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.application.WorkmanShowOneApplicationCommand;
import ua.training.repairagency.controller.commands.roles.workman.profile.WorkmanEditprofileCommand;
import ua.training.repairagency.controller.commands.roles.workman.profile.WorkmanProfilePageCommand;
import ua.training.repairagency.controller.constants.URL;

public class CommandsCreator {
	
	public static Map<String, Command> create(Map<String, Command> commands) {
		commands = new HashMap<>();
		
		new LogoutCommand(commands);
		new LoginCommand(commands);
		new RegistrationCommand(commands);
		new Error404Command(commands);
		new IndexPageCommand(commands);
		
		new CustomerProfilePageCommand(commands);
		new CustomerEditprofileCommand(commands);
		new CustomerApplicationCommand(commands);
		new CustomerCreateApplicationCommand(commands);
		new CustomerShowAllApplicationCommand(commands);
		new CustomerShowOneApplicationCommand(commands);
		new CustomerShowDoneApplicationCommand(commands);
		new CustomerFinishApplicationCommand(commands);
		new CustomerEditApplicationCommand(commands);
//		commands.put(URL.CUSTOMER_APPLICATIONS_CURRENT_PATH, new CustomerShowCurrentApplicationCommand());
		new CustomerShowReceivedApplicationCommand(commands);
		new CustomerApproveApplicationCommand(commands);
		new CustomerShowActiveApplicationCommand(commands);
		new CustomerShowNonactiveApplicationCommand(commands);
		
		new ManagerProfilePageCommand(commands);
		new ManagerEditprofileCommand(commands);
		new ManagerApplicationCommand(commands);
		new ManagerShowAllApplicationCommand(commands);
		new ManagerShowOneApplicationCommand(commands);
//		new ManagerShowDoneApplicationCommand(commands);
		new ManagerFinishApplicationCommand(commands);
		new ManagerEditApplicationCommand(commands);
		new ManagerApproveEditApplicationCommand(commands);
//		commands.put(URL.MANAGER_APPLICATIONS_CURRENT_PATH, new ManagerShowDoneApplicationCommand());
		new ManagerShowNewApplicationCommand(commands);
//		new ManagerApproveApplicationCommand(commands);
		new ManagerShowActiveApplicationCommand(commands);
		new ManagerShowNonactiveApplicationCommand(commands);
		new ManagerSearchByIdApplicationCommand(commands);
		new ManagerCreateUserCommand(commands);
		new ManagerUsersCommand(commands);
		new ManagerShowUsersCommand(commands);
		new ManagerEditUserCommand(commands);
		new ManagerDeleteUserCommand(commands);
		
		new WorkmanProfilePageCommand(commands);
		new WorkmanEditprofileCommand(commands);
		new WorkmanApplicationCommand(commands);
		new WorkmanShowOneApplicationCommand(commands);
		new WorkmanFinishApplicationCommand(commands);
		new WorkmanEditApplicationCommand(commands);
		new WorkmanShowNewApplicationCommand(commands);
		new WorkmanApproveApplicationCommand(commands);
		new WorkmanShowActiveApplicationCommand(commands);
		new WorkmanShowNonactiveApplicationCommand(commands);
		
		return commands;
	}

}
