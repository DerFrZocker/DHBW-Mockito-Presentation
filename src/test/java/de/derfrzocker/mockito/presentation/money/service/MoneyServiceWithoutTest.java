package de.derfrzocker.mockito.presentation.money.service;

import de.derfrzocker.mockito.presentation.money.dao.MoneyDao;
import de.derfrzocker.mockito.presentation.money.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyServiceWithoutTest {

    @Test
    void testAddMoney() {
        MoneyDao moneyDao = new MoneyTestDao();
        MoneyService moneyService = new MoneyService(moneyDao);

        Person person = new Person("Test-Person");

        int newValue = moneyService.addMoney(person, 30);

        assertEquals(50, newValue);
    }

    static class MoneyTestDao implements MoneyDao {

        private final Person expected = new Person("Test-Person");

        @Override
        public int getMoney(Person person) {
            assertEquals(expected, person);
            return 20;
        }

        @Override
        public void setMoney(Person person, int amount) {
            assertEquals(expected, person);
            assertEquals(50, amount);
        }
    }
}
