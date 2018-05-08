package ua.training.repairagency.controller.commands;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public interface Command {
	
	Logger loggerAuth = Logger.getLogger(Command.class);
		
	String execute(HttpServletRequest request);	

}
