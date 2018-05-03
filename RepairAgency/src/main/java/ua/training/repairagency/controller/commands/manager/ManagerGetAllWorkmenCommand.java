package ua.training.repairagency.controller.commands.manager;

import static ua.training.repairagency.controller.constants.URL.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.model.services.manager.GetAllWorkmenService;

public class ManagerGetAllWorkmenCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			 {
		
		request.setAttribute("command_result", new GetAllWorkmenService().execute());

		return MANAGER_PAGE;
	}

}
