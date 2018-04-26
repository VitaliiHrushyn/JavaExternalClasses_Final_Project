package ua.training.repairagency.controller.commands.manager;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.services.manager.GetAllWorkmenService;

public class ManagerGetAllWorkmenCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		//TODO delete stub
		List<User> workers = new ArrayList<>();
		workers.add(new UserImpl());
		workers.add(new UserImpl());
		workers.add(new UserImpl());
		//
		
		request.setAttribute("workers", new GetAllWorkmenService().execute());

		return MANAGER_PAGE;
	}

}
