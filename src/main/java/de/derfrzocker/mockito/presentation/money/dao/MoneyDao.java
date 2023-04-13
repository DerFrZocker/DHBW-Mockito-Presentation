package de.derfrzocker.mockito.presentation.money.dao;

import de.derfrzocker.mockito.presentation.money.model.Person;

public interface MoneyDao {

     int getMoney(Person person);

    void setMoney(Person person, int amount);
}
