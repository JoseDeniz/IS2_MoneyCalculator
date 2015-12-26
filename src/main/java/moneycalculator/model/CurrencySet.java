package moneycalculator.model;

import java.util.ArrayList;
import java.util.List;

public class CurrencySet {

    private final List<Currency> list;

    public CurrencySet() {
        list = new ArrayList<>();
    }

    public void add(Currency currency) {
        list.add(currency);
    }

    public Currency[] toArray() {
        return list.toArray(new Currency[list.size()]);
    }

}
