package ua.training.repairagency.model.services.manager;

import java.util.ArrayList;
import java.util.List;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.services.Service;

//TODO decide if implementation (and Service interface at all) needed
public class GetAllWorkmenService implements Service {
	
	@SuppressWarnings("unchecked")
	public List<User> execute() {
		//TODO delete stub
		List<User> workers = new ArrayList<>();
		workers.add(new UserImpl());
		workers.add(new UserImpl());
		workers.add(new UserImpl());
		//
		return workers;
	}

}
