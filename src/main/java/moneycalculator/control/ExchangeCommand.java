package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.view.persistence.ExchangeRateReader;
import moneycalculator.view.ui.CurrencyDialog;
import moneycalculator.view.ui.MoneyDialog;
import moneycalculator.view.ui.MoneyDisplay;

public class ExchangeCommand implements Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateReader reader;
    private final MoneyDisplay display;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateReader reader, MoneyDisplay display) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.reader = reader;
        this.display = display;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.getMoney();
        Currency to = currencyDialog.getCurrency();
        ExchangeRate exchangeRate = reader.read(new Currency("EUR", "Euro", "€"), to);
        display.display(money);
    }

}
