package moneycalculator.application.swing;

import moneycalculator.control.ExchangeCommand;
import moneycalculator.model.Currency;
import moneycalculator.view.ui.ExchangeDialog;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {

    private final Currency[] currencies;
    private ExchangeDialog exchangeDialog;

    public ApplicationFrame(Currency[] currencies) {
        this.currencies = currencies;
        deployUI();
    }

    private void deployUI() {
        this.setTitle("Money calculator");
        this.setSize(250, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createWidgets();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createWidgets() {
        this.add(createCalculateButton(), BorderLayout.SOUTH);
        this.add(createExchangeDialogPanel());
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> new ExchangeCommand(exchangeDialog).execute());
        return button;
    }

    private JPanel createExchangeDialogPanel() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencies);
        this.exchangeDialog = panel;
        return panel;
    }

}

