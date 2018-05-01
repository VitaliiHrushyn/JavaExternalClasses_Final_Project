package ua.training.repairagency.model.utils;

import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.*;

import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public class DAOutils {
	
	public static String getFailMessageFromException(NotUniqueFieldValueException e) {
		String errorMessage = e.getMessage();
		String field = null;
		if (errorMessage.contains(LOGIN)) {
			field = LOGIN;
		}
		if (errorMessage.contains(EMAIL)) {
			field = EMAIL;
		}
		if (errorMessage.contains(PHONE)) {
			field = PHONE;
		}		
		return field + " is not unique";
	}

}
