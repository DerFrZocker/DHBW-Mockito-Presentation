package de.derfrzocker.mockito.presentation.currency.service;

import de.derfrzocker.mockito.presentation.currency.dao.CurrencyDao;
import de.derfrzocker.mockito.presentation.currency.model.Currency;

public class CurrencyService {

    private final CurrencyDao currencyDao;

    public CurrencyService(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    public double convert(Currency from, Currency to, double amount) {
        double fromFactor = currencyDao.getCurrencyFactor(from);
        double toFactor = currencyDao.getCurrencyFactor(to);

        double normalized = amount * fromFactor;

        return normalized / toFactor;
    }
}
