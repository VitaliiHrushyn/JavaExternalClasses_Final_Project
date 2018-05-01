package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import ua.training.repairagency.model.entities.user.UserRole;

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

}
