package moneycalculator.application.swing;

import moneycalculator.application.Exchange;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.view.ui.ExchangeDialog;

import javax.swing.*;
import java.awt.*;

import static java.lang.Double.parseDouble;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog {

    private Currency[] currencies;

    private JTextField inputAmount;

    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;
    private JTextArea result;
    public ExchangeDialogPanel(Currency[] currencies) {
        this.currencies = currencies;
        this.setLayout(new FlowLayout());
        this.createWidgets();
    }

    @Override
    public JTextField getContent() {
        return inputAmount;
    }

    private void createWidgets() {
        this.add(createAmountWidget(), BorderLayout.CENTER);
        this.add(createFromCurrencyWidget(), BorderLayout.CENTER);
        this.add(createToCurrencyWidget(), BorderLayout.CENTER);
        this.add(createResultWidget(), BorderLayout.CENTER);
    }

    private JTextField createAmountWidget() {
        JTextField input = new JTextField(10);
        this.inputAmount = input;
        return input;
    }

    private JTextArea createResultWidget() {
        JTextArea resultText = new JTextArea("Introduce a value");
        result = resultText;
        return  resultText;
    }

    private JComboBox createFromCurrencyWidget() {
        JComboBox<Currency> fromCurrencyComboBox = new JComboBox<>(currencies);
        this.fromCurrency = fromCurrencyComboBox;
        return fromCurrencyComboBox;
    }

    private JComboBox createToCurrencyWidget() {
        JComboBox<Currency> toCurrencyComboBox = new JComboBox<>(currencies);
        this.toCurrency = toCurrencyComboBox;
        return toCurrencyComboBox;
    }

    @Override
    public void setResultText(String message) {
        result.setText(message);
    }

    @Override
    public Money getMoney() {
        return new Exchange(fromMoney(), getCurrency(toCurrency)).getMoney();
    }

    private Money fromMoney() {
        return new Money(amount(), getCurrency(fromCurrency));
    }

    private double amount() {
        String amountValue = inputAmount.getText();
        return amountValue.isEmpty() ? 0.0 : parseNumber(amountValue);
    }

    private double parseNumber(String amountValue) {
        return parseDouble(amountValue.replaceAll(",", "."));
    }

    private Currency getCurrency(JComboBox<Currency> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }

}
