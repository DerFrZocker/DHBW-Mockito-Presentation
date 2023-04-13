package de.derfrzocker.mockito.presentation.currency.service;

import de.derfrzocker.mockito.presentation.currency.dao.CurrencyDao;
import de.derfrzocker.mockito.presentation.currency.model.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CurrencyServiceWithTest {

    @Test
    void testConversion() {
        CurrencyDao currencyDao = mock(invocation -> {throw new AssertionError("Unexpected Method call");});

        doReturn(0.5).when(currencyDao).getCurrencyFactor(Currency.YEN);
        doReturn(5.0).when(currencyDao).getCurrencyFactor(Currency.EURO);

        CurrencyService currencyService = new CurrencyService(currencyDao);
        double converted = currencyService.convert(Currency.YEN, Currency.EURO, 10);

        assertEquals(1.0, converted, 0.01);

        verify(currencyDao, times(2)).getCurrencyFactor(any());
    }
}
