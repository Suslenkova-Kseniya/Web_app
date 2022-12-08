package main.java.by.bsuir.WT.lab4.controller.command;

import main.java.by.bsuir.WT.lab4.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}
