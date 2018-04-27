package ua.training.repairagency.controller.filters.roleauthfilters;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns="/*")
public class WorkmanFilter extends AbstractRoleFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.WORKMAN);
	}

	@Override
	protected boolean validateURI() {
		return request.getRequestURI().contains("workman");
	}
	
	//TODO make it properly
	@Override
	protected String getCommandPageURI() {
		return null; //request.getContextPath() + WORKMAN_PAGE_COMMAND;
	}	

}
