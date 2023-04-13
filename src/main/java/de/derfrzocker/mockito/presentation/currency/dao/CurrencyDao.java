package de.derfrzocker.mockito.presentation.currency.dao;

import de.derfrzocker.mockito.presentation.currency.model.Currency;

public interface CurrencyDao {

    double getCurrencyFactor(Currency currency);

    void saveCurrencyFactor(Currency currency, double factor);
}
