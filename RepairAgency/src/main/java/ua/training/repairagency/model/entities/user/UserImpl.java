package ua.training.repairagency.model.entities.user;
import java.util.List;

import ua.training.repairagency.model.entities.AbstractEntity;
import ua.training.repairagency.model.entities.application.Application;

public class UserImpl extends AbstractEntity implements User {	
	
	private UserRole role;
	private String name;
	private String surname;
	private String login;
	private String password;
	private String email;
	private String phone;
	private List<Application> applications;

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
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public List<Application> getApplications() {
		return applications;
	}

	@Override
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "UserImpl [role=" + role + ", name=" + name + ", login=" + login + ", password=" + password + ", email="
				+ email + ", phone=" + phone + ", applications=" + applications + "]";
	}
	
	
	
	//TODO equals and hash code
	
//	/**
//     * User builder
//     */
//    public static final class UserBuilder {
//        private Integer id;
//        private UserRole role;
//        private String name;
//        private String login;
//        private String password;
//        private String email;
//        private String phone;
//
//        public UserBuilder setId(Integer id) {
//            this.id = id;
//            return this;
//        }
//
//        public UserBuilder setRole(UserRole role) {
//            this.role = role;
//            return this;
//        }
//
//        public UserBuilder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public UserBuilder setLogin(String login) {
//            this.login = login;
//            return this;
//        }
//
//        public UserBuilder setPassword(String password) {
//            this.password = password;
//            return this;
//        }
//        
//        public UserBuilder setEmail(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public UserBuilder setPhone(String phone) {
//            this.phone = phone;
//            return this;
//        }
//
//        public User build(){
//            User user = new UserImpl();
//            user.setId(id);
//            user.setRole(role);
//            user.setName(name);
//            user.setLogin(login);
//            user.setPassword(password);
//            user.setEmail(email);
//            user.setPhone(phone);
//            return user;
//        }
//    }

}
