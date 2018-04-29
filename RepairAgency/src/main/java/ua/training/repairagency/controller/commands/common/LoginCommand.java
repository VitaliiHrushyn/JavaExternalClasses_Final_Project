package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.services.GetUserByLoginService;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");		
		HttpSession session = request.getSession();
		
		String message = null;
		String path = LOGIN_PAGE;
		
		//TODO : use Optional to avoid checking for a null
		
		if ((login != null && password != null) && (!login.isEmpty() && !password.isEmpty())) {		
			
			//TODO properly			
			User user = new GetUserByLoginService().execute(login);			
			if (user != null && user.getPassword().equals(password)) {
				UserRole role = user.getRole();
				path = CommandUtils.getPathFrom(role);
				session.setAttribute("user", user);
			} else {
				message = "login or/and password are wrong";
			}
			
		} else {
			message = "login or/and password are empty";
			session.setAttribute("user", null);
		}	
		request.setAttribute("loginmessage", message);
		
		return path;
	}

	

}
