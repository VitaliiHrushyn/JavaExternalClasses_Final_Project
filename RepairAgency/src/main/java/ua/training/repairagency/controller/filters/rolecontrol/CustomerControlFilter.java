package ua.training.repairagency.controller.filters.rolecontrol;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class CustomerControlFilter extends AbstractRoleControlFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.CUSTOMER);
	}

	@Override
	protected boolean validateRoleURI() {
		return request.getRequestURI().contains(URL.CUSTOMER);
	}

	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + URL.CUSTOMER_PAGE_COMMAND;
	}	

}
