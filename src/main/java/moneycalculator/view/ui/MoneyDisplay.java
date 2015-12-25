package moneycalculator.view.ui;

import moneycalculator.model.Money;

@FunctionalInterface
public interface MoneyDisplay {
    void display(Money money);
}
