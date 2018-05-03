package ua.training.repairagency.controller.filters.rolecontrol;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class ManagerControlFilter extends AbstractRoleControlFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.MANAGER);
	}

	@Override
	protected boolean validateRoleURI() {
		return request.getRequestURI().contains(URL.MANAGER);
	}

	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + URL.MANAGER_PAGE_COMMAND;
	}	

}
