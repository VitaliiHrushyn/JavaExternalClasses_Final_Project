package ua.training.repairagency.controller.filters.rolefilters;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.AttributeOrParam;

import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter
public class CustomerFilter extends AbstractRoleFilter implements Filter {

	@Override
	protected boolean validateRole() {
		return role.equals(UserRole.CUSTOMER);
	}

	@Override
	protected boolean validateRoleURI() {
		return request.getRequestURI().contains(AttributeOrParam.CUSTOMER);
	}

	@Override
	protected String getRolePageCommandURI() {
		return request.getContextPath() + URL.CUSTOMER_PAGE_COMMAND;
	}	

}
