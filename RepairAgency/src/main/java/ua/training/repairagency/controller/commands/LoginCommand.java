package ua.training.repairagency.controller.commands;

import static ua.training.repairagency.controller.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		String message;
		String path;
		
		if (!username.isEmpty() && !password.isEmpty()) {		
			message = "command - name: "+username+", pass: "+password;
			session.setAttribute("user", "stub");
			path = INDEX_PAGE;
		} else {
			message = "login command empty";
			session.setAttribute("user", null);
			path = LOGIN_PAGE;
		}
			
		request.setAttribute("message", message);
		
System.out.println("login command user: "+request.getSession().getAttribute("user"));

		return path;
	}

}
