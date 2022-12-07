package main.java.by.bsuir.WT.lab4.dao.impl;

import main.java.by.bsuir.WT.lab4.dao.AbstractDao;
import main.java.by.bsuir.WT.lab4.dao.Table;
import main.java.by.bsuir.WT.lab4.dao.api.UserInformationDao;
import main.java.by.bsuir.WT.lab4.dao.mapper.RowMapperFactory;
import main.java.by.bsuir.WT.lab4.entity.UserInformation;
import main.java.by.bsuir.WT.lab4.exeptions.DaoException;

public class UserInformationDaoImpl extends AbstractDao<UserInformation> implements UserInformationDao {
    private static final String SAVE_USER_INFORMATION_QUERY = "INSERT INTO " + Table.USER_INFORMATION +
            " (name, surname,  phone) VALUES (?, ?, ?)";
    private static final String UPDATE_BY_ID =
            "UPDATE "+ Table.USER_INFORMATION +"  SET name=?, surname=?, phone=?, WHERE account_id=?";

    public UserInformationDaoImpl() {
        super(RowMapperFactory.getInstance().getUserInformationRowMapper(), Table.USER_INFORMATION);
    }

    @Override
    public int save(UserInformation userInformation) throws DaoException {
        return executeInsertQuery(SAVE_USER_INFORMATION_QUERY, userInformation.getName(),
                userInformation.getSurname(),  userInformation.getPhone());
    }

    @Override
    public void updateById(int id, UserInformation userInformation) throws DaoException {
        executeUpdateQuery(UPDATE_BY_ID,userInformation.getName(),userInformation.getSurname(),userInformation.getPhone(),id);
    }
}
