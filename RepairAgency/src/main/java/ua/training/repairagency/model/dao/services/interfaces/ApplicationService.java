package ua.training.repairagency.model.dao.services.interfaces;

import java.util.List;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.exceptions.OutOfDateDataException;

public interface ApplicationService {
		
	List<Application> getAll(int pageNumber);
	
	List<Application> getAllByUserId(int pageNumber, int userId);
	
	Application insert(Application application) throws Exception;

	Application getById(int id);

	Application update(Application application) throws OutOfDateDataException;

	List<Application> getAllByStatuses(int pageNumber, String... values);

	List<Application> getAllByCustomerIdAndStatuses(int pageNumber, String... values);

	List<Application> getAllByWorkmanIdAndStatuses(int pageNumber, String... values);

	int getNumberOfPagesByQuery(String query, String... values);


}
