package ua.training.repairagency.model.services.manager;

import java.util.ArrayList;
import java.util.List;

import ua.training.repairagency.model.dao.interfaces.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.services.Service;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class CreateManagerService implements Service {
	
//	@SuppressWarnings("unchecked")
	public User execute() {
		//TODO delete stub
		User manager = new UserImpl();
		manager.setRole(UserRole.MANAGER);
		manager.setName("Manager name");
		manager.setLogin("manager");
		manager.setPassword("1");
		manager.setEmail("email");
		manager.setPhone("5622167");		
		
		User createdManager = null;
		try(UserDAO dao = DAOFactory.getInstance().createUserDAO()){
			createdManager = dao.create(manager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdManager;
	}
	
	

}
