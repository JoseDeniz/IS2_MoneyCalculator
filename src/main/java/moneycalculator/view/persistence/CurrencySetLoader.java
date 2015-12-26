package moneycalculator.view.persistence;

import moneycalculator.model.CurrencySet;

@FunctionalInterface
public interface CurrencySetLoader {
    CurrencySet load();
}
