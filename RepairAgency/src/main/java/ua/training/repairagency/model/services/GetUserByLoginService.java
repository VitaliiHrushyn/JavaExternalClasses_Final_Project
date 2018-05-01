package ua.training.repairagency.model.services;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class GetUserByLoginService implements Service {
	
	public User execute(String login) {
		
		User user = null;
		try(UserDAO dao = DAOFactory.getInstance().createUserDAO()){
			user = dao.getByParam(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}	

}
