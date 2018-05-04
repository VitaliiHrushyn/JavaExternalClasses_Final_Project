package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.services.interfaces.InsertUser;
import ua.training.repairagency.model.utils.DAOutils;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class InsertUserService extends AbstractService implements InsertUser {
	
	public User insert(User user) throws NotUniqueFieldValueException {
				
		try(UserDAO dao = daoFactory.createUserDAO()) {		
			return dao.create(user);				
		} catch (Exception e) {
			DAOutils.checkIfNotUniqueFieldValueException(e);
			return null;
		}		 
	}	
	
}
