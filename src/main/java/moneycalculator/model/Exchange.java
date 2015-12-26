package moneycalculator.model;

import moneycalculator.view.persistence.DatabaseExchangeRateReader;

public class Exchange {

    private final Money from;
    private final Currency to;

    public Exchange(Money from, Currency to) {
        this.from = from;
        this.to = to;
    }

    public Money getMoney() {
        ExchangeRate exchangeRate = new DatabaseExchangeRateReader().read(from.getCurrency(), to);
        return new Money(from.getAmount() * exchangeRate.getRate(), to);
    }

}
