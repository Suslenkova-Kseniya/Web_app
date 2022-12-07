package main.java.by.bsuir.WT.lab4.dao.impl;

import main.java.by.bsuir.WT.lab4.dao.AbstractDao;
import main.java.by.bsuir.WT.lab4.dao.Table;
import main.java.by.bsuir.WT.lab4.dao.api.RoleDao;
import main.java.by.bsuir.WT.lab4.dao.mapper.RowMapperFactory;
import main.java.by.bsuir.WT.lab4.entity.Role;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;

import java.util.Optional;

public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    private static final String SAVE_ROLE_QUERY = "INSERT INTO " + Table.ROLE + " (role) VALUES (?)";
    private static final String FIND_ROLE_BY_NAME_QUERY = "SELECT * FROM " + Table.ROLE + " WHERE role=?";

    public RoleDaoImpl() {
        super(RowMapperFactory.getInstance().getRoleRowMapper(), Table.ROLE);
    }

    @Override
    public int save(Role role) throws DaoException {
        return executeInsertQuery(SAVE_ROLE_QUERY, role.getName());
    }

    @Override
    public Optional<Role> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_ROLE_BY_NAME_QUERY, name);
    }
}
