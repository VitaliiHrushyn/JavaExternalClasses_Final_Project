package ua.training.repairagency.model.dao.services.interfaces;

import java.util.List;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public interface UserService {
	
	User getById(int userId);
	
	User getByLogin(String login);
	
	User insert(User user) throws NotUniqueFieldValueException;

	User update(User user) throws NotUniqueFieldValueException;

	List<User> getAllByRole(UserRole role);

}
