package moneycalculator.view.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

@FunctionalInterface
public interface ExchangeRateReader {
    ExchangeRate read(Currency from, Currency to);
}
