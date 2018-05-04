package ua.training.repairagency.model.services.interfaces;

import ua.training.repairagency.model.entities.user.User;

public interface FetchUserByLogin {	

	public User fetch(String login);

}
