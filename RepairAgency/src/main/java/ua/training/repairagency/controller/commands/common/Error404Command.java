package ua.training.repairagency.controller.commands.common;

import ua.training.repairagency.controller.constants.URL;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class Error404Command implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return URL.PAGE_404;
	}

}
