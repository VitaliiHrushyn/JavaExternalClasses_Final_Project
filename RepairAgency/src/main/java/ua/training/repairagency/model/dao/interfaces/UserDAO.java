package ua.training.repairagency.model.dao.interfaces;

import java.util.List;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

public interface UserDAO extends GenericDAO<User> {
	
	User getByLogin(String login);

	List<User> getAllByRoleWithLimitAndOffset(UserRole role, int pageNumber);

	int coutnRowsByRole(UserRole role);

	List<User> getAllByRole(UserRole role);
	
}
