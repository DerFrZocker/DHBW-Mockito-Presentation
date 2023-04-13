package de.derfrzocker.mockito.presentation.money.dao;

import de.derfrzocker.mockito.presentation.money.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLMoneyDaoImpl implements MoneyDao {

    private final Connection connection;

    public SQLMoneyDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int getMoney(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT money FROM account where name=?");
            statement.setString(1, person.name());

            ResultSet resultSet = statement.executeQuery();

            return resultSet.getInt("money");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setMoney(Person person, int amount) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE account SET money=? WHERE name=?");
            statement.setInt(1, amount);
            statement.setString(2, person.name());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
