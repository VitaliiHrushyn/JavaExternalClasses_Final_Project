package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.LOGGED_USERS;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.model.entities.user.User;

public class AccessUtils {
	
	@SuppressWarnings("unchecked")
	public static void setUserAsLogged(HttpServletRequest request, int userId) {
		ServletContext context = request.getSession().getServletContext();
		
		Map<Integer, HttpSession> loggedUsers = 
				context.getAttribute(LOGGED_USERS) != null 
				? (HashMap<Integer, HttpSession>) context.getAttribute(LOGGED_USERS)
				: new HashMap<Integer, HttpSession>();

		HttpSession previousSession = loggedUsers.put(userId, request.getSession());
		if (previousSession != null) {
			previousSession.removeAttribute(USER);
		}
		context.setAttribute(LOGGED_USERS, loggedUsers);		
	}

	@SuppressWarnings("unchecked")
	public static void deleteUserFromLoggedUsers(HttpSession session) {
		int userId = ((User) session.getAttribute(USER)).getId();
		ServletContext context = session.getServletContext();
		Map<Integer, HttpSession> loggedUsers = (HashMap<Integer, HttpSession>) context.getAttribute(LOGGED_USERS);
		loggedUsers.remove(userId);
		context.setAttribute(LOGGED_USERS, loggedUsers);
	}	
	
}
