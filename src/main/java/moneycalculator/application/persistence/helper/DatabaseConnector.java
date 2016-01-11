package moneycalculator.application.persistence.helper;

import javaslang.control.Try;

import java.sql.Connection;

import static java.sql.DriverManager.getConnection;

public class DatabaseConnector {

    public static Try<Connection> tryConnection() {
        return Try.of(() -> getConnection("jdbc:sqlite:src/main/resources/currencies.db"));
    }

}
