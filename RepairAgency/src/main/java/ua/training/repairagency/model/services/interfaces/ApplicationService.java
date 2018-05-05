package ua.training.repairagency.model.services.interfaces;

import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;

public interface ApplicationService {
	
	Application getAll();
	
	Application getByUserId(int userId);
	
	Application getByStatus(AppStatus atatus);
	
	Application getByStatusAndUserId(AppStatus status, int userId);
	
	Application insert(Application application);

}
