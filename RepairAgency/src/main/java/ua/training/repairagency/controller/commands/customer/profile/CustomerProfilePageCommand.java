package ua.training.repairagency.controller.commands.customer.profile;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.profile.AbstractProfilePageCommand;

public class CustomerProfilePageCommand extends AbstractProfilePageCommand {

	@Override
	protected String getProfilePage() {
		return URL.CUSTOMER_PROFILE_PAGE;
	}
	
}
