package moneycalculator.view.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static moneycalculator.view.persistence.helper.DatabaseConnector.tryConnection;

public class DatabaseCurrencySetLoader implements CurrencySetLoader {

    @Override
    public CurrencySet load() {
        return tryConnection()
                    .mapTry(Connection::createStatement)
                    .mapTry(this::executeSelectCurrencyInfo)
                    .mapTry(this::toCurrencySet)
                    .get();
    }

    private ResultSet executeSelectCurrencyInfo(Statement statement) throws SQLException {
        return statement.executeQuery("SELECT * FROM currency_info");
    }

    private CurrencySet toCurrencySet(ResultSet resultSet) throws SQLException {
        CurrencySet currencySet = new CurrencySet();
        while(resultSet.next())
            currencySet.add(currency(resultSet));
        return currencySet;
    }

    private Currency currency(ResultSet resultSet) throws SQLException {
        return new Currency(resultSet.getString("code"),
                            resultSet.getString("name"),
                            resultSet.getString("symbol"));
    }
}
