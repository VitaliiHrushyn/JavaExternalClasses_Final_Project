package ua.training.repairagency.model.entities.user;
import ua.training.repairagency.model.entities.AbstractEntity;

public class UserImpl extends AbstractEntity implements User {
	
	
	private UserRole role;

	@Override
	public UserRole getRole() {
		return role;
	}

	@Override
	public void setRole(UserRole role) {
		this.role = role;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub

	}

}
