package ua.training.repairagency.controller.commands;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.dao.services.ServiceFactory;

public abstract class AbstractCommand implements Command {
	
	protected ResourceBundle messageBundle;
	protected ServiceFactory serviceFactory = ServiceFactory.getInstance();
	protected List<String> infoMessages;
	protected List<String> errorMessages;
	protected String page;
	
	@Override
	public abstract String execute(HttpServletRequest request);

}
