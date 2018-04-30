package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.PathConstants.LOGIN_PAGE;
import static ua.training.repairagency.controller.constants.PathConstants.REDIRECT_CUSTOMER_PAGE;
import static ua.training.repairagency.controller.constants.PathConstants.REDIRECT_MANAGER_PAGE;
import static ua.training.repairagency.controller.constants.PathConstants.REDIRECT_WORKMAN_PAGE;

import ua.training.repairagency.model.entities.user.UserRole;

public class CommandUtils {
	
	public static String getPathFrom(UserRole role) {
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

}
