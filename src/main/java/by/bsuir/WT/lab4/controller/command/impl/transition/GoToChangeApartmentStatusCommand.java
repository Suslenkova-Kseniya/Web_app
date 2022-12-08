package main.java.by.bsuir.WT.lab4.controller.command.impl.transition;

import main.java.by.bsuir.WT.lab4.controller.command.Command;
import main.java.by.bsuir.WT.lab4.controller.command.CommandResult;
import main.java.by.bsuir.WT.lab4.controller.command.CommandResultType;
import main.java.by.bsuir.WT.lab4.controller.context.RequestContext;
import main.java.by.bsuir.WT.lab4.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public class GoToChangeApartmentStatusCommand implements Command {
    private static final String PAGE = "WEB-INF/view/changeApartmentStatus.jsp";



    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();


        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
