package de.derfrzocker.mockito.presentation.currency.service;

import de.derfrzocker.mockito.presentation.currency.dao.CurrencyDao;
import de.derfrzocker.mockito.presentation.currency.model.Currency;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CurrencyServiceTest {

    @Test
    @Disabled
    void testConversion() {
        CurrencyDao currencyDao = mock(invocation -> {throw new AssertionError("Unexpected Method call");});

        when(currencyDao.getCurrencyFactor(Currency.YEN)).thenReturn(0.5);
        when(currencyDao.getCurrencyFactor(Currency.EURO)).thenReturn(5.0);

        CurrencyService currencyService = new CurrencyService(currencyDao);
        double converted = currencyService.convert(Currency.YEN, Currency.EURO, 10);

        assertEquals(1.0, converted, 0.01);

        // TODO: 4/10/23 Write verify
    }
}
