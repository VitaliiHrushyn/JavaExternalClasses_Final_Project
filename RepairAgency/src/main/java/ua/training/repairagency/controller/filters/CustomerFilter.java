package ua.training.repairagency.controller.filters;

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
	protected boolean validateURI() {
		return request.getRequestURI().contains("customer");
	}

	@Override
	protected String getCommandPageURI() {
		return null; // request.getContextPath() + CUSTOMER_PAGE_COMMAND;
	}	

}
