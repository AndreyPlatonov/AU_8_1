package ru.netology.sql.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private final static QueryRunner runner = new QueryRunner();

    private SQLHelper() {

    }

    private static Connection getConn() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static void cleanDatabase() {

        var connection = getConn();
        runner.execute(connection, "DELETE FROM card_transactions;");
        runner.execute(connection, "DELETE FROM auth_codes;");
        runner.execute(connection, "DELETE FROM cards;");
        runner.execute(connection, "DELETE FROM users;");

    }

    @SneakyThrows
    public static DataHelper.VerificationCode getVerificationCode() {

        var codeSQl = "SELECT code FROM AUTH_CODES ORDER BY code DESC LIMIT 1";
        var conn = getConn();
        var code = runner.query(conn, codeSQl, new ScalarHandler<String>());
        return new DataHelper.VerificationCode(code);
    }


}