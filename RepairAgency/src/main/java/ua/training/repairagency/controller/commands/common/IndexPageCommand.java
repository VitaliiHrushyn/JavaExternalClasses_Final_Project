package ua.training.repairagency.controller.commands.common;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;

public class IndexPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		return URL.INDEX_PAGE;
	}

}
