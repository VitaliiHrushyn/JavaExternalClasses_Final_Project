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
	
	private static final Logger authLogger = Logger.getLogger(Command.class);
	
	@SuppressWarnings("unchecked")
	private static void setUserAsLogged(HttpServletRequest request, User user) {
		ServletContext context = request.getSession().getServletContext();
		
		Map<Integer, HttpSession> loggedUsers = 
				context.getAttribute(LOGGED_USERS) != null 
				? (HashMap<Integer, HttpSession>) context.getAttribute(LOGGED_USERS)
				: new HashMap<Integer, HttpSession>();

		HttpSession previousSession = loggedUsers.put(user.getId(), request.getSession());
		authLogger.info("Login success: " + user 
				+ " to session " + request.getSession().getId() + ";");
		if (previousSession != null && !previousSession.isNew()) { //TODO check this conditions !!!
			previousSession.setAttribute(USER, null);
			authLogger.info("Double login protection - automatic logout of " 
					+ request.getSession().getAttribute(USER) + " from session " + previousSession.getId() + ";");
		}
		context.setAttribute(LOGGED_USERS, loggedUsers);		
	}

	@SuppressWarnings("unchecked")
	public static void logoutUser(HttpSession session) {
		User user = ((User) session.getAttribute(USER));
		ServletContext context = session.getServletContext();
		Map<Integer, HttpSession> loggedUsers = (HashMap<Integer, HttpSession>) context.getAttribute(LOGGED_USERS);
		loggedUsers.remove(user.getId());
		context.setAttribute(LOGGED_USERS, loggedUsers);
		session.setAttribute(USER, null);
		authLogger.info("Logout of " + user + ";");
	}
	
	public static String loginUserAndGetUserPage(HttpServletRequest request, User user) {
		if (user == null) {
			return URL.LOGIN_PAGE;
		} else {
			request.getSession().setAttribute(USER, user);
			setUserAsLogged(request, user);
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
