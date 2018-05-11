package ua.training.repairagency.controller.commands.abstracts.profile;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractProfilePageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		return getProfilePage();
	}
	
	protected abstract String getProfilePage();

}
