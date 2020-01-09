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
                    DbConfig.DB_PASSWORD
            );

            stmt = c.createStatement();



//            sql = "INSERT INTO CINEMA_LIFE.CINEMA (ID, NAME, CITY)" +
//                    "VALUES (1, \'Пять Звезд\', \'Москва\')";
//            stmt.executeUpdate(sql);
//
//
//            sql = "INSERT INTO CINEMA_LIFE.SCREEN (ID, CINEMA_ID, NAME, ROWS, SEATS_IN_ROW)" +
//                    "VALUES (1, 1, \'Зал 1\', 10, 25)";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO CINEMA_LIFE.SCREEN (ID, CINEMA_ID, NAME, ROWS, SEATS_IN_ROW)" +
//                    "VALUES (2, 1, \'Зал 2\', 25, 42)";
//            stmt.executeUpdate(sql);


            sql = "INSERT INTO CINEMA_LIFE.FILM (name, director, year)" +
                    "VALUES (\'Kill Bill\', \'Quentin Tarantino\', 2003)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.FILM (name, director, year)" +
                    "VALUES (\'Jumanji: The Next Level\', \'Jake Kasdan\', 2019)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.FILM (name, director, year)" +
                    "VALUES (\'Knives Out\', \'Rian Johnson\', 2019)";
            stmt.executeUpdate(sql);


            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (1, 1, \'2019-12-20 11:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (1, 2, \'2019-12-20 13:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (1, 3, \'2019-12-20 15:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (2, 1, \'2019-12-20 17:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (2, 3, \'2019-12-20 19:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (1, 3, \'2019-12-21 15:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (1, 1, \'2019-12-21 10:00:00\')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CINEMA_LIFE.SHOW_TIME (screen_id, film_id, date_time)" +
                    "VALUES (2, 2, \'2019-12-21 21:00:00\')";
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
