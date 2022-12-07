package main.java.by.bsuir.WT.lab4.service.api;

import main.java.by.bsuir.WT.lab4.entity.User;
import main.java.by.bsuir.WT.lab4.entity.UserOrder;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<User> login(String email, String password) throws ServiceException;


    boolean register(String name, String surname,  String email, String phone, String password) throws ServiceException;


    Optional<User> retrieveUserById(int userId) throws ServiceException;

    public List<User> getUsersFromOrders(List<UserOrder> orders) throws ServiceException;


}
