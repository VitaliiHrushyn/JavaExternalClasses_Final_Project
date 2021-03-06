package ua.training.repairagency.model.utils;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public class DAOutils {
	
	public static void extractNotUniqueFieldValueException(Exception e) 
												throws NotUniqueFieldValueException  {
		
		if ( e.getClass().equals(SQLIntegrityConstraintViolationException.class) 
				&& ((SQLException) e).getErrorCode() == 1062 ) {			
			throw new NotUniqueFieldValueException(e);		
		} else {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean paramNotEmpty(String value) {
		return value != null && !value.isEmpty();
	}

	
}
