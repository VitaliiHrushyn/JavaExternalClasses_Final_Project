package ua.training.repairagency.controller.filters.roleauthfilters;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns="/*")
public class CustomerFilter extends AbstractRoleFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.CUSTOMER);
	}

	@Override
	protected boolean validateRoleURI() {
		return request.getRequestURI().contains("customer");
	}

	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + CUSTOMER_PAGE_COMMAND;
	}	

}
