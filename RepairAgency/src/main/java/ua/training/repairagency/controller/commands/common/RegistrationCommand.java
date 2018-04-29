package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.services.CreateUserService;
import ua.training.repairagency.model.services.Service;

public class RegistrationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String login = request.getParameter("reglogin");
		String password = request.getParameter("regpassword");
		String confirmpassword = request.getParameter("confirmpassword");
				
		HttpSession session = request.getSession();
		
		String message = null;
		String path;
		
		//TODO : use Optional to avoid checking for a null
		
		if ((login != null && password != null && confirmpassword != null) && 
				(!login.isEmpty() && !password.isEmpty()) && !confirmpassword.isEmpty() &&
				password.equals(confirmpassword)) {		
			
			User user = new CreateUserService().execute(request);
			
			session.setAttribute("user", user);
					
			path = CommandUtils.getPathFrom(user.getRole());
		} else {
			message = "register command is invalid";
			session.setAttribute("user", null);
			path = LOGIN_PAGE;
		}
			
		request.setAttribute("regmessage", message);
		
//System.out.println("reg comm session role: "+((User) request.getSession().getAttribute("user")).getRole().toString());
		return path;
	}

}
