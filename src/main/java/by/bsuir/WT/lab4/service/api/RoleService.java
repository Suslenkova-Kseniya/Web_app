package main.java.by.bsuir.WT.lab4.service.api;

import main.java.by.bsuir.WT.lab4.entity.Role;
import main.java.by.bsuir.WT.lab4.exeptions.ServiceException;

import java.util.Optional;

public interface RoleService {

    Optional<Role> retrieveRoleById(int roleId) throws ServiceException;
    Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException;

}
