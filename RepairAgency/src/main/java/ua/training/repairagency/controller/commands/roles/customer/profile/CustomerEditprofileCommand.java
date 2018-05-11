package ua.training.repairagency.controller.commands.roles.customer.profile;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.profile.AbstractEditprofileCommand;

public class CustomerEditprofileCommand extends AbstractEditprofileCommand {

	@Override
	protected String getEditprofilePage() {
		return URL.CUSTOMER_EDITPROFILE_PAGE;
	}		
	
}
