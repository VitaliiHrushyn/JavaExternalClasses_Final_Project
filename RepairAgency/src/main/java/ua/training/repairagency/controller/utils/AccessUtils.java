package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.LOGGED_USERS;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.model.entities.user.User;

public class AccessUtils {
	
	@SuppressWarnings("unchecked")
	public static boolean setUserAsLogged(HttpServletRequest request, int userId) {
		ServletContext context = request.getSession().getServletContext();		
		Set<Integer> loggedUsers = 
				context.getAttribute(LOGGED_USERS) != null 
				? (HashSet<Integer>) context.getAttribute(LOGGED_USERS)
				: new HashSet<>();

		boolean flag = loggedUsers.add(userId);
		context.setAttribute(LOGGED_USERS, loggedUsers);		
		return flag;		
	}

	@SuppressWarnings("unchecked")
	public static void deleteUserFromLoggedUsers(HttpSession session) {
		int userId = ((User) session.getAttribute(USER)).getId();
		ServletContext context = session.getServletContext();
		Set<Integer> loggedUsers = (HashSet<Integer>) context.getAttribute(LOGGED_USERS);
		loggedUsers.remove(userId);
		context.setAttribute(LOGGED_USERS, loggedUsers);
	}	
	
}
