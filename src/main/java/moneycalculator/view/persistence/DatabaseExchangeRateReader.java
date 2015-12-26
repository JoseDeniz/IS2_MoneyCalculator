package moneycalculator.view.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static moneycalculator.view.persistence.helper.DatabaseConnector.tryConnection;

public class DatabaseExchangeRateReader implements ExchangeRateReader {

    private Currency from;
    private Currency to;

    @Override
    public ExchangeRate read(Currency from, Currency to) {
        this.from = from;
        this.to = to;
        return searchExchangeRate();
    }

    private ExchangeRate searchExchangeRate() {
        return tryConnection()
                    .mapTry(Connection::createStatement)
                    .mapTry(this::executeSelectRatesQuery)
                    .andThen(ResultSet::next)
                    .mapTry(this::toExchangeRate)
                    .get();
    }

    private ResultSet executeSelectRatesQuery(Statement statement) throws SQLException {
        return statement.executeQuery(selectRatesQuery());
    }

    private String selectRatesQuery() {
        return String.format("SELECT * FROM currency_rates " +
                             "WHERE currency_from='%s'" +
                             "AND currency_to='%s'",
                             from.getCode(), to.getCode());
    }

    private ExchangeRate toExchangeRate(ResultSet resultSet) throws SQLException {
        return new ExchangeRate(from, to, resultSet.getDouble("rate"));
    }

}
