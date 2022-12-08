package main.java.by.bsuir.WT.lab4.controller.command.impl;

import main.java.by.bsuir.WT.lab4.controller.command.Command;
import main.java.by.bsuir.WT.lab4.controller.command.CommandResult;
import main.java.by.bsuir.WT.lab4.controller.command.CommandResultType;
import main.java.by.bsuir.WT.lab4.controller.context.RequestContext;
import main.java.by.bsuir.WT.lab4.controller.context.RequestContextHelper;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;
import main.java.by.bsuir.WT.lab4.service.ServiceFactory;
import main.java.by.bsuir.WT.lab4.service.api.UserOrderService;

import javax.servlet.http.HttpServletResponse;

public class CompleteOrderCommand implements Command {
    private static final String PAGE = "command=viewOrders";
    private static final String USER_ORDER_ID = "userOrderId";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CONFIRMED = "confirmed";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            int userOrderId = Integer.parseInt(requestContext.getRequestParameter(USER_ORDER_ID));
            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            userOrderService.updateStatusAtUserOrderById(userOrderId, CONFIRMED);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.REDIRECT);
    }
}
