package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;
import static ua.training.repairagency.controller.constants.Message.*;
import static ua.training.repairagency.controller.constants.URL.*;

import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public class CommandUtils {
	
	public static String getPathFromRole(UserRole role) {
		if (role.equals(UserRole.CUSTOMER)) {
			return REDIRECT_CUSTOMER_PAGE;
		}
		if (role.equals(UserRole.MANAGER)) {
			return REDIRECT_MANAGER_PAGE;
		}
		if (role.equals(UserRole.WORKMAN)) {
			return REDIRECT_WORKMAN_PAGE;
		}
		return LOGIN_PAGE;
	}
	
	public static String getFailMessageFromException(NotUniqueFieldValueException e) {
		String exceptionErrorMessage = e.getMessage();
		String exceptionMessage = null;
		if (exceptionErrorMessage.contains(LOGIN)) {
			exceptionMessage = NOT_UNIQUE_LOGIN_MESSAGE;
		}
		if (exceptionErrorMessage.contains(EMAIL)) {
			exceptionMessage = NOT_UNIQUE_EMAIL_MESSAGE;
		}
		if (exceptionErrorMessage.contains(PHONE)) {
			exceptionMessage = NOT_UNIQUE_PHONE_MESSAGE;
		}		
		return exceptionMessage;
	}

}
