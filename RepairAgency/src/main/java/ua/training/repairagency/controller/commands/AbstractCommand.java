package ua.training.repairagency.controller.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand implements Command {

	protected List<String> messages;
	protected String path;
	
	@Override
	public abstract String execute(HttpServletRequest request);

}
