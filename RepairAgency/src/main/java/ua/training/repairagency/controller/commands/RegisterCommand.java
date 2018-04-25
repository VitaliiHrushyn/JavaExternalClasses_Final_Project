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
		
	//	System.out.println("reg comm "+username+password+confirmpassword);
		
		HttpSession session = request.getSession();
		
		String message;
		String path;
		
		//TODO : use Optional to avoid checking for a null
		
		if ((username != null && password != null && confirmpassword != null) && 
				(!username.isEmpty() && !password.isEmpty()) && !confirmpassword.isEmpty() &&
				password.equals(confirmpassword)) {		
			message = "REGISTER command - name: "+username+", pass: "+password;
			
			//TODO remake this user creation stub
			User newUser = new UserImpl();
			newUser.setRole(UserRole.ADMIN);
			newUser.setLogin("admin");
			newUser.setPassword("admin");
			
			//
			
			
			session.setAttribute("user", newUser);
			
			
			path = ADMIN_PAGE;
		} else {
			message = "register command is invalid";
			session.setAttribute("user", null);
			path = LOGIN_PAGE;
		}
			
		request.setAttribute("message", message);
		
System.out.println("register command user: "+ ((User) request.getSession().getAttribute("user")).getRole().toString());

		return path;
	}

}
