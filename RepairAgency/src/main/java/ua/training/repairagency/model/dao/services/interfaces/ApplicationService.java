package ua.training.repairagency.model.dao.services.interfaces;

import java.util.List;

import ua.training.repairagency.model.entities.application.Application;

public interface ApplicationService {
		
	List<Application> getAll();
	
	List<Application> getAllByUserId(int userId);
	
	//List<Application> getByStatus(AppStatus atatus);
	
//	List<Application> getAllByUserIdAndStatuses(int userId, String... statuses);
	
	Application insert(Application application) throws Exception;

	Application getById(int id);

	Application update(Application application);

	List<Application> getAllByStatuses(String... values);

	List<Application> getAllByUserIdAndStatuses(String... values);

	List<Application> getAllById(int id);

}
