package main.java.by.bsuir.WT.lab4.dao;

import main.java.by.bsuir.WT.lab4.exeptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> findAll() throws DaoException;

    Optional<T> findById(int id) throws DaoException;

    int save(T item) throws DaoException;

    void removeById(int id) throws DaoException;
}
