package moneycalculator.control;

import moneycalculator.model.Money;
import moneycalculator.view.ui.ExchangeDialog;

public class ExchangeCommand implements Command {

    private final ExchangeDialog exchangeDialog;

    public ExchangeCommand(ExchangeDialog exchangeDialog) {
        this.exchangeDialog = exchangeDialog;
    }

    @Override
    public void execute() {
        if (isInputCorrect()) {
            Money money = exchangeDialog.getMoney();
            exchangeDialog.setResultText(String.format("%.5f\n%s", money.getAmount(), money.getCurrency()));
        }
        else exchangeDialog.setResultText("Incorrect input!");
    }

    private boolean isInputCorrect() {
        return exchangeDialog.getContent().getText().matches("\\d+([\\.,]?\\d+)?");
    }
}
