package ua.training.repairagency.model.services.interfaces;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public interface UserService {
	
	User getById(int userId);
	
	User getByLogin(String login);
	
	User insert(User user) throws NotUniqueFieldValueException;

}
