package ua.training.repairagency.model.dao.services.interfaces;

import java.util.List;

import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;

public interface ApplicationService {
	
	//Application getById(int id);
	
	List<Application> getAll();
	
	List<Application> getAllByUserId(int userId);
	
	List<Application> getByStatus(AppStatus atatus);
	
	List<Application> getByStatusAndUserId(AppStatus status, int userId);
	
	Application insert(Application application) throws Exception;

}
