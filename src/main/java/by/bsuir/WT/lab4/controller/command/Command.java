package main.java.by.bsuir.WT.lab4.controller.command;

import by.bsuir.wt.fourth.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}
