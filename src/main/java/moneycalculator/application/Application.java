package moneycalculator.application;

import moneycalculator.application.persistence.DatabaseCurrencySetLoader;
import moneycalculator.application.swing.ApplicationFrame;
import moneycalculator.model.CurrencySet;

public class Application {

    public static void main(String[] args) {
        CurrencySet currencySet = new DatabaseCurrencySetLoader().load();
        new ApplicationFrame(currencySet.toArray());
    }

}
