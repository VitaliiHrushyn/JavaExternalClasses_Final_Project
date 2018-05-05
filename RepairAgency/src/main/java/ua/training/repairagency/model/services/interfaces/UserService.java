package ua.training.repairagency.model.services.interfaces;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public interface UserService {
	
	User getUserByLogin(String login);
	
	User insertUser(User user) throws NotUniqueFieldValueException;

}
