package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.PAGE_404;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class Error404Command implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return PAGE_404;
	}

}
