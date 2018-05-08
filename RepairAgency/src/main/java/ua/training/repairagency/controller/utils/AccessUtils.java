package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.LOGGED_USERS;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

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
	
	public static String loginUserAndGetUsePage(HttpServletRequest request, User user) {
		if (user == null) {
			return URL.LOGIN_PAGE;
		} else {
			request.getSession().setAttribute(USER, user);
			setUserAsLogged(request, user.getId());
			return getPageFromRole(user.getRole());
		}		
	}
	
	private static String getPageFromRole(UserRole role) {
		if (role.equals(UserRole.CUSTOMER)) {
			return URL.REDIRECT_CUSTOMER_PROFILE_COMMAND;
		}
		if (role.equals(UserRole.MANAGER)) {
			return URL.REDIRECT_MANAGER_PROFILE_COMMAND;
		}
		if (role.equals(UserRole.WORKMAN)) {
			return URL.REDIRECT_WORKMAN_PROFILE_COMMAND;
		}
		return URL.LOGIN_PAGE;
	}
	
}
