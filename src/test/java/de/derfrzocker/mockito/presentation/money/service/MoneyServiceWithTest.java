package de.derfrzocker.mockito.presentation.money.service;

import de.derfrzocker.mockito.presentation.money.dao.MoneyDao;
import de.derfrzocker.mockito.presentation.money.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MoneyServiceWithTest {

    @Test
    void testAddMoney() {
        Person person = new Person("Test-Person");

        MoneyDao moneyDao = mock();
        when(moneyDao.getMoney(person)).thenReturn(20);

        MoneyService moneyService = new MoneyService(moneyDao);

        int newValue = moneyService.addMoney(person, 30);

        assertEquals(50, newValue);

        verify(moneyDao).getMoney(person);
        verify(moneyDao).setMoney(person, 50);
        verifyNoMoreInteractions(moneyDao);
    }
}
