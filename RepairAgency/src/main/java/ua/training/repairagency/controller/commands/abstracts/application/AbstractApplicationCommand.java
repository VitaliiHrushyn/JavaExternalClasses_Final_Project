package ua.training.repairagency.controller.commands.abstracts.application;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractApplicationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
				
		return getApplicationIndexPage();
	}
	
	protected abstract String getApplicationIndexPage();

}
