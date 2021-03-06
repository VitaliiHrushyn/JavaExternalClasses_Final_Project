package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;

public abstract class AbstractShowListApplicationCommand extends AbstractCommand {

	public AbstractShowListApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {

		
		List<Application> applications = new ArrayList<>();
		applications = getApplications(request, CommandUtils.extractPageNumberFromRequest(request));
					
		request.setAttribute(PAGINATION_LINK, getPaginationLink(request));
		request.setAttribute(APPLICATIONS, applications);
		request.setAttribute(NUMBER_OF_PAGES, getNumberOfPages());
		
		return getApplicationPage(); 
	}
	
	private String getPaginationLink(HttpServletRequest request){
			return request.getContextPath() + URL.CONTEXT_ADDON + getPath() + URL.PAGE_NUMBER;	
	}
	
	protected abstract String getPath();
	protected abstract String getApplicationPage();
	protected abstract List<Application> getApplications(HttpServletRequest request, int pageNumber);
	protected abstract int getNumberOfPages();
}