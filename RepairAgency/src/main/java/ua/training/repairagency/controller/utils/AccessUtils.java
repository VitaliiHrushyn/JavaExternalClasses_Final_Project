package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.LOGGED_USERS;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

public class AccessUtils {
	
	private static Map<String, HttpSession> loggedUsers;
	
	private static final Logger authLogger = Logger.getLogger(Command.class);
	
	@SuppressWarnings("unchecked")
	private static void setUserToLoggedUsersMap(HttpServletRequest request, User user) {
		ServletContext context = request.getServletContext();
		
		/* 
		 * Contains map with user login and session which this user is logged in
		 */
				loggedUsers = context.getAttribute(LOGGED_USERS) != null 
				? (HashMap<String, HttpSession>) context.getAttribute(LOGGED_USERS)
				: new HashMap<String, HttpSession>();
		/*
		 *  put new user_login-user_session entry to map 
		 *  and get back old session of this user to previousSession variable  
		 */
		HttpSession previousSession = loggedUsers.put(user.getLogin(), request.getSession());
		
		authLogger.info("Login success: " + user 
				+ " to session " + request.getSession().getId() + ";");
		
		if (previousSession != null) { //TODO check this conditions !!!
			previousSession.invalidate();     //setAttribute(USER, null);
			
			authLogger.info("Double login protection - automatic logout of " 
					+ request.getSession().getAttribute(USER) + " from session " + previousSession.getId() + ";");
		}
		
		context.setAttribute(LOGGED_USERS, loggedUsers);		
	}

	@SuppressWarnings("unchecked")
	public static void logoutUser(HttpSession session) {
		
		User user = ((User) session.getAttribute(USER));
		ServletContext context = session.getServletContext();
		loggedUsers = (HashMap<String, HttpSession>) context.getAttribute(LOGGED_USERS);
		loggedUsers.remove(user.getLogin());
		context.setAttribute(LOGGED_USERS, loggedUsers);
		session.setAttribute(USER, null);
		
		authLogger.info("Logout of " + user + ";");
	}
	
	public static String loginUserAndGetUserPage(HttpServletRequest request, User user) {
		if (user == null) {
			return URL.LOGIN_PAGE;
		} else {
			request.getSession().setAttribute(USER, user);
			setUserToLoggedUsersMap(request, user);
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

	@SuppressWarnings("unchecked")
	public static void changeLoginOfLoggedUser(HttpServletRequest request, String oldLogin, String newLogin) {
		
		ServletContext context = request.getServletContext();
		loggedUsers = (HashMap<String, HttpSession>) context.getAttribute(LOGGED_USERS);
		
		HttpSession currentSession = loggedUsers.remove(oldLogin);
		loggedUsers.put(newLogin, currentSession);		
		
		context.setAttribute(LOGGED_USERS, loggedUsers);		
	}
	
}
