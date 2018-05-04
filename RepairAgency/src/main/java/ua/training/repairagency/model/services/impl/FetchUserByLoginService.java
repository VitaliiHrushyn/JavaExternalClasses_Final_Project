package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.interfaces.FetchUserByLogin;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class FetchUserByLoginService extends AbstractService implements FetchUserByLogin {	

	public User fetch(String login) {
		User user = null;
		try(UserDAO dao = daoFactory.createUserDAO()){
			user = dao.getByParam(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}

}
