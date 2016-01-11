package moneycalculator.application;

import moneycalculator.application.persistence.DatabaseExchangeRateReader;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;

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
