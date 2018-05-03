package ua.training.repairagency.model.services;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class GetUserByLoginService extends AbstractService {
	
	String login;	
	
	public GetUserByLoginService(String login) {
		super();
		this.login = login;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User execute() {
		
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
