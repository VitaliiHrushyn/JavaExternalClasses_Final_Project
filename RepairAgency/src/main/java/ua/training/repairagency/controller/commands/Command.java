package ua.training.repairagency.controller.commands;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.services.interfaces.ServiceFactory;

public interface Command {
	
	ServiceFactory serviceFactory = ServiceFactory.getInstance();
	
	String execute(HttpServletRequest request);	

}
