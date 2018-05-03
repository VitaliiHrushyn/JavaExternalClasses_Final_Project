package ua.training.repairagency.controller.filters.rolecontrol;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class WorkmanControlFilter extends AbstractRoleControlFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.WORKMAN);
	}

	@Override
	protected boolean validateRoleURI() {
		return request.getRequestURI().contains(URL.WORKMAN);
	}
	
	//TODO make it properly
	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + URL.WORKMAN_PAGE_COMMAND;
	}	

}
