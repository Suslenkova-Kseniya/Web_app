package main.java.by.bsuir.WT.lab4.dao.api;

import main.java.by.bsuir.WT.lab4.dao.Dao;
import main.java.by.bsuir.WT.lab4.entity.Role;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {


    Optional<Role> findByName(String name) throws DaoException;
}