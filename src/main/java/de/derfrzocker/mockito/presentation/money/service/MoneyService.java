package de.derfrzocker.mockito.presentation.money.service;

import de.derfrzocker.mockito.presentation.money.dao.MoneyDao;
import de.derfrzocker.mockito.presentation.money.model.Person;

public class MoneyService {

    private final MoneyDao moneyDao;

    public MoneyService(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    /**
     * Adds the given amount to the given person
     * and return the new money amount of the given person.
     *
     * @param person to add money
     * @param amount to add to the persons account
     * @return the new amount of money the given person has
     */
    public int addMoney(Person person, int amount) {
        int current = moneyDao.getMoney(person);

        int newAmount = current + amount;

        moneyDao.setMoney(person, newAmount);

        return newAmount;
    }
}
