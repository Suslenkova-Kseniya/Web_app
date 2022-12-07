package main.java.by.bsuir.WT.lab4.service.api;

import main.java.by.bsuir.WT.lab4.entity.User;
import main.java.by.bsuir.WT.lab4.entity.UserInformation;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException;


    List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException;
}
