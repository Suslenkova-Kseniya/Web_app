package main.java.by.bsuir.WT.lab4.service.impl;

import main.java.by.bsuir.WT.lab4.dao.DaoFactory;
import main.java.by.bsuir.WT.lab4.dao.impl.UserInformationDaoImpl;
import main.java.by.bsuir.WT.lab4.entity.User;
import main.java.by.bsuir.WT.lab4.entity.UserInformation;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;
import main.java.by.bsuir.WT.lab4.service.api.UserInformationService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserInformationServiceImpl implements UserInformationService {


    @Override
    public Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException {
        try {
            UserInformationDaoImpl userInformationDao = DaoFactory.getInstance().getUserInformationDao();
            Optional<UserInformation> result;
            result = userInformationDao.findById(userInformationId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException {
        List<UserInformation> userInformation = new LinkedList<>();
        try {
            for (User user : users) {
                Optional<UserInformation> information = retrieveUserInformationById(user.getUserInformationId());
                if (information.isPresent()) {
                    if (!userInformation.contains(information.get())) {
                        userInformation.add(information.get());
                    }
                }
            }
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return userInformation;
    }
}
