package ua.training.repairagency.model.services.manager;

import java.util.ArrayList;
import java.util.List;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;
import ua.training.repairagency.model.services.Service;

//TODO decide if implementation (and Service interface at all) needed
public class GetAllAppsService implements Service {
	
	@SuppressWarnings("unchecked")
	public List<Application> execute() {
		//TODO delete stub
		List<Application> applications = new ArrayList<>();
		applications.add(new ApplicationImpl());
		applications.add(new ApplicationImpl());
		applications.add(new ApplicationImpl());
		//
		return applications;
	}	

}
