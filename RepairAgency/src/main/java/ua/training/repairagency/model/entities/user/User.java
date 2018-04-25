package ua.training.repairagency.model.entities.user;

import ua.training.repairagency.model.entities.Entity;

public interface User extends Entity {
	
	UserRole getRole();
	
	void setRole (UserRole role);
	
	String getName();
	
	void setName(String name);
	
	String getLogin();
	
	void setLogin(String login);
	
	String getPassword();
	
	void setPassword(String password);
	
	String getEmail();
	
	void setEmail(String email);
	
	String getPhone();
	
	void setPhone(String phone);

}
