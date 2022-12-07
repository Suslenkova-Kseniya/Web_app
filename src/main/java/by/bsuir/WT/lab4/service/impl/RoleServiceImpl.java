package main.java.by.bsuir.WT.lab4.service.impl;

import main.java.by.bsuir.WT.lab4.dao.DaoFactory;
import main.java.by.bsuir.WT.lab4.dao.api.RoleDao;
import main.java.by.bsuir.WT.lab4.entity.Role;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;
import main.java.by.bsuir.WT.lab4.service.api.RoleService;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {

    @Override
    public Optional<Role> retrieveRoleById(int roleId) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findByName(roleName);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }
}