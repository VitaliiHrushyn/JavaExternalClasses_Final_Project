package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.URL.INDEX_PAGE;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class IndexPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		request.setAttribute("message", "INDEX page");

		return INDEX_PAGE;
	}

}
