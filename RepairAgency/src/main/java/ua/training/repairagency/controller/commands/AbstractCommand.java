package ua.training.repairagency.controller.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.dao.services.interfaces.ServiceFactory;

public abstract class AbstractCommand implements Command {

	protected ServiceFactory serviceFactory = ServiceFactory.getInstance();
	protected List<String> messages;
	protected String path;
	
	@Override
	public abstract String execute(HttpServletRequest request);

}
