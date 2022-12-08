package main.java.by.bsuir.WT.lab4.controller.command.impl.transition;

import main.java.by.bsuir.WT.lab4.controller.command.Command;
import main.java.by.bsuir.WT.lab4.controller.command.CommandResult;
import main.java.by.bsuir.WT.lab4.controller.command.CommandResultType;
import main.java.by.bsuir.WT.lab4.controller.context.RequestContext;
import main.java.by.bsuir.WT.lab4.controller.context.RequestContextHelper;
import main.java.by.bsuir.WT.lab4.entity.Apartment;
import main.java.by.bsuir.WT.lab4.entity.User;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;
import main.java.by.bsuir.WT.lab4.service.ServiceFactory;
import main.java.by.bsuir.WT.lab4.service.api.ApartmentService;
import main.java.by.bsuir.WT.lab4.service.api.RoleService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToCatalogCommand implements Command {
    private static final String PAGE = "WEB-INF/view/catalog.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String APARTMENTS = "apartments";
    private static final String STATUS = "доступно";
    private static final String USER = "user";
    private static final String ADMIN_ROLE = "admin";



    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            ApartmentService apartmentService= ServiceFactory.getInstance().getApartmentService();
            try {
                List<Apartment> apartment=apartmentService.retrieveApartamentByStatus(STATUS);
                requestContext.addRequestAttribute(APARTMENTS,apartment);
                helper.updateRequest(requestContext);
            } catch (ServiceException e) {
                return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
            }
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }

        try {
            RoleService roleService=ServiceFactory.getInstance().getRoleService();
            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartment;
            if (roleService.retrieveRoleById(user.getRoleId()).get().getName().equals(ADMIN_ROLE)){
                apartment=apartmentService.retrieveALLApartaments();
            }else {
                apartment=apartmentService.retrieveApartamentByStatus(STATUS);
            }
            requestContext.addRequestAttribute(APARTMENTS,apartment);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}

