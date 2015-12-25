package moneycalculator.view.ui;

import moneycalculator.model.Currency;

@FunctionalInterface
public interface CurrencyDialog {
    Currency getCurrency();
}
