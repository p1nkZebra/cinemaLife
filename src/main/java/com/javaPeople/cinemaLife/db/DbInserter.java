package com.javaPeople.cinemaLife.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbInserter {

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "3$Jf&z#9d*&2"
            );

            stmt = c.createStatement();



            sql = "INSERT INTO CINEMA_LIFE.CINEMA (ID, NAME, CITY)" +
                    "VALUES (1, \'Пять Звезд\', \'Москва\')";
            stmt.executeUpdate(sql);



            sql = "INSERT INTO CINEMA_LIFE.SCREEN (ID, CINEMA_ID, NAME, ROWS, SEATS_IN_ROW)" +
                    "VALUES (1, 1, \'Зал 1\', 10, 25)";
            stmt.executeUpdate(sql);



            sql = "INSERT INTO CINEMA_LIFE.SCREEN (ID, CINEMA_ID, NAME, ROWS, SEATS_IN_ROW)" +
                    "VALUES (2, 1, \'Зал 2\', 25, 42)";
            stmt.executeUpdate(sql);



            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Inserts are executed successfully");
    }
}
