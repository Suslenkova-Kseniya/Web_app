package main.java.by.bsuir.WT.lab4.dao.api;


import main.java.by.bsuir.WT.lab4.dao.Dao;
import main.java.by.bsuir.WT.lab4.entity.User;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {


    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;


    Optional<User> findByEmail(String email) throws DaoException;
}
