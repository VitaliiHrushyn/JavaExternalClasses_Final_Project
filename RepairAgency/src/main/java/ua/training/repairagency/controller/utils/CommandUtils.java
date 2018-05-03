package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import ua.training.repairagency.controller.constants.AttributeOrParam;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public class CommandUtils {
	
	public static String getPathFromRole(UserRole role) {
		if (role.equals(UserRole.CUSTOMER)) {
			return URL.REDIRECT_CUSTOMER_PAGE;
		}
		if (role.equals(UserRole.MANAGER)) {
			return URL.REDIRECT_MANAGER_PAGE;
		}
		if (role.equals(UserRole.WORKMAN)) {
			return URL.REDIRECT_WORKMAN_PAGE;
		}
		return URL.LOGIN_PAGE;
	}
	
	public static String getFailMessageFromException(NotUniqueFieldValueException e) {
		String exceptionErrorMessage = e.getMessage();
		String exceptionMessage = null;
		if (exceptionErrorMessage.contains(AttributeOrParam.LOGIN)) {
			exceptionMessage = Message.NOT_UNIQUE_LOGIN;
		}
		if (exceptionErrorMessage.contains(AttributeOrParam.EMAIL)) {
			exceptionMessage = Message.NOT_UNIQUE_EMAIL;
		}
		if (exceptionErrorMessage.contains(AttributeOrParam.PHONE)) {
			exceptionMessage = Message.NOT_UNIQUE_PHONE;
		}		
		return exceptionMessage;
	}
	
	public static String doCrypt(String string) {
		return DigestUtils.md5Hex(string.getBytes());
	}
	
	public static User createUser(HttpServletRequest request) {
		User user = new UserImpl();
		user.setRole(UserRole.valueOf(request.getParameter(ROLE)));
		user.setName(request.getParameter(NAME));
		user.setSurname(request.getParameter(SURNAME));
		user.setLogin(request.getParameter(REGISTRATION_LOGIN));
		user.setPassword(doCrypt(request.getParameter(REGISTRATION_PASSWORD)));
		user.setEmail(request.getParameter(EMAIL));
		user.setPhone(request.getParameter(PHONE));	
		user.setApplications(null);
		
		return user;
	}
	
}
