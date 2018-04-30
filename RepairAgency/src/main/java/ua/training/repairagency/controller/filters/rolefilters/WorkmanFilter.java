package ua.training.repairagency.controller.filters.rolefilters;

import static ua.training.repairagency.controller.constants.PathConstants.*;
import static ua.training.repairagency.controller.constants.AttributeConstants.*;

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
	protected boolean validateRoleURI() {
		return request.getRequestURI().contains(WORKMAN_ATTRIBUTE);
	}
	
	//TODO make it properly
	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + WORKMAN_PAGE_COMMAND;
	}	

}
