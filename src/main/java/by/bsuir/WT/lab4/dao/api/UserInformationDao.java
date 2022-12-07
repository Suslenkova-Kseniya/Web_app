package main.java.by.bsuir.WT.lab4.dao.api;


import main.java.by.bsuir.WT.lab4.dao.Dao;
import main.java.by.bsuir.WT.lab4.entity.UserInformation;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;

public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
