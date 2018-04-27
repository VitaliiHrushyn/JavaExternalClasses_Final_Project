package ua.training.repairagency.controller.filters.authentication;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns="/*")
public class ManagerFilter extends AbstractRoleFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.MANAGER);
	}

	@Override
	protected boolean validateURI() {
		return request.getRequestURI().contains("manager");
	}

	@Override
	protected String getCommandPageURI() {
		return request.getContextPath() + MANAGER_PAGE_COMMAND;
	}	

}
