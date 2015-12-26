package moneycalculator.view.ui;

import moneycalculator.model.Money;

import javax.swing.*;

public interface ExchangeDialog {

    void setResultText(String message);

    JTextField getContent();

    Money getMoney();

}
