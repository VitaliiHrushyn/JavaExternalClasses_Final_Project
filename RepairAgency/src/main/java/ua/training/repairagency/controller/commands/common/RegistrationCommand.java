package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.*;
import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.CreateUserService;

public class RegistrationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		String login = request.getParameter("reglogin");
		String password = request.getParameter("regpassword");
		String confirmpassword = request.getParameter("confirmpassword");
				
		HttpSession session = request.getSession();
		
		String message = null;
		String path;
		
		//TODO : use Optional to avoid checking for a null
		
		if (checkLoginPasswordConfirm(login, password, confirmpassword)) {				
			User user = new CreateUserService().execute(request);			
			session.setAttribute(USER, user);
			path = CommandUtils.getPathFromRole(user.getRole());
		} else {
			message = "register command is invalid";
			path = LOGIN_PAGE;
		}
			
		request.setAttribute("regmessage", message);
		
//System.out.println("reg comm session role: "+((User) request.getSession().getAttribute("user")).getRole().toString());
		return path;
	}

	private boolean checkLoginPasswordConfirm(String login, String password, String confirmpassword) {
		return (login != null && password != null && confirmpassword != null) && 
				(!login.isEmpty() && !password.isEmpty()) && !confirmpassword.isEmpty() &&
				password.equals(confirmpassword);
	}

}
