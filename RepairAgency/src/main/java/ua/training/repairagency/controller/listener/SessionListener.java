package ua.training.repairagency.controller.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ua.training.repairagency.controller.utils.CommandUtils;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {}

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        CommandUtils.deleteUserFromLoggedUsers(httpSessionEvent.getSession());
    }
}