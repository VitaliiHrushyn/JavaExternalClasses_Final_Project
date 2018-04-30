package ua.training.repairagency.controller.filters.rolefilters;

import static ua.training.repairagency.controller.constants.PathConstants.*;
import static ua.training.repairagency.controller.constants.AttributeConstants.*;

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
		return request.getRequestURI().contains(CUSTOMER_ATTRIBUTE);
	}

	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + CUSTOMER_PAGE_COMMAND;
	}	

}
