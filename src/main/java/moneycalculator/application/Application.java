package moneycalculator.application;

import moneycalculator.application.swing.ApplicationFrame;
import moneycalculator.model.CurrencySet;
import moneycalculator.view.persistence.DatabaseCurrencySetLoader;

public class Application {

    public static void main(String[] args) {
        CurrencySet currencySet = new DatabaseCurrencySetLoader().load();
        new ApplicationFrame(currencySet.toArray());
    }

}
