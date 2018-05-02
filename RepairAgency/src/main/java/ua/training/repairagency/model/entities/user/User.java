package ua.training.repairagency.model.entities.user;

import java.util.List;

import ua.training.repairagency.model.entities.Entity;
import ua.training.repairagency.model.entities.application.Application;

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
	
	List<Application> getApplications();
	
	void setApplications(List<Application> applications);
	
}
