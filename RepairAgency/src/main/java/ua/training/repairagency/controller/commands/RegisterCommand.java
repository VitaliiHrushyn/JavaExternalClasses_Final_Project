package ua.training.repairagency.controller.commands;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class RegisterCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String username = request.getParameter("regusername");
		String password = request.getParameter("regpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		
		
		HttpSession session = request.getSession();
		
		String message = null;
		String path;
		
		//TODO : use Optional to avoid checking for a null
		
		if ((username != null && password != null && confirmpassword != null) && 
				(!username.isEmpty() && !password.isEmpty()) && !confirmpassword.isEmpty() &&
				password.equals(confirmpassword)) {		
			
			//TODO remake this user creation stub
			User newUser = new UserImpl();
			newUser.setRole(UserRole.MANAGER);
			newUser.setLogin("manager");
			newUser.setPassword("manager");
			
			//
			
			
			session.setAttribute("user", newUser);
			
			
			path = REDIRECT_MANAGER_COMMAND;
		} else {
			message = "register command is invalid";
			session.setAttribute("user", null);
			path = LOGIN_PAGE;
		}
			
		request.setAttribute("message", message);
		

		return path;
	}

}
