package ua.training.repairagency.controller.commands;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		String message = null;
		String path;
		
		//TODO : use Optional to avoid checking for a null
		
		if ((username != null && password != null) && (!username.isEmpty() && !password.isEmpty())) {		
			
			//TODO properly
		
			User user = new UserImpl();
			if (username.equals("manager")) {
				user.setRole(UserRole.MANAGER);
				path = REDIRECT_MANAGER_PAGE;
			} else {
				user.setRole(UserRole.CUSTOMER);
				path = REDIRECT_CUSTOMER_PAGE;
			}
			// 
			
			session.setAttribute("user", user);
			
		} else {
			message = "login or/and password are wrong";
			session.setAttribute("user", null);
			path = LOGIN_PAGE;		
		}	
		request.setAttribute("loginmessage", message);
		
		return path;
	}

}
