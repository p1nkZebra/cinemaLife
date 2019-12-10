package com.javaPeople.cinemaLife.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbCreator {

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



            sql = "CREATE SCHEMA IF NOT EXISTS  CINEMA_LIFE ";
            stmt.executeUpdate(sql);



            sql = "CREATE TABLE IF NOT EXISTS CINEMA_LIFE.CINEMA "
                    + " ( "
                    + " ID                SERIAL PRIMARY KEY      NOT NULL, "
                    + " NAME              VARCHAR(100)            NOT NULL,  "
                    + " CITY              VARCHAR(100)            NOT NULL  "
                    + " ) ";
            stmt.executeUpdate(sql);



            sql = "CREATE TABLE IF NOT EXISTS CINEMA_LIFE.FILM "
                    + " ( "
                    + " ID                        SERIAL PRIMARY KEY      NOT NULL, "
                    + " NAME                      VARCHAR(100)            NOT NULL, "
                    + " DIRECTOR                  VARCHAR(100)            NOT NULL, "
                    + " YEAR                      INT                     NOT NULL "
                    + " ) ";
            stmt.executeUpdate(sql);



            sql = "CREATE TABLE IF NOT EXISTS CINEMA_LIFE.PRICE "
                    + " ( "
                    + " ID                        SERIAL PRIMARY KEY      NOT NULL, "
                    + " AMOUNT                    INT                     NOT NULL, "
                    + " START_TIME                TIME                    NOT NULL, "
                    + " END_TIME                  TIME                    NOT NULL "
                    + " ) ";
            stmt.executeUpdate(sql);



            sql = "CREATE TABLE IF NOT EXISTS CINEMA_LIFE.SCREEN "
                    + " ( "
                    + " ID                        SERIAL PRIMARY KEY      NOT NULL, "
                    + " CINEMA_ID                 INT                     NOT NULL, "
                    + " NAME                      VARCHAR(100)            NOT NULL, "
                    + " ROWS                      INT                     NOT NULL, "
                    + " SEATS_IN_ROW              INT                     NOT NULL  "
                    + " ) ";
            stmt.executeUpdate(sql);



            sql = "ALTER TABLE CINEMA_LIFE.SCREEN "
                    + " ADD CONSTRAINT FK_CINEMA "
                    + " FOREIGN KEY ( CINEMA_ID ) REFERENCES CINEMA_LIFE.CINEMA (ID) MATCH FULL "
                    + " ";
            stmt.executeUpdate(sql);



            sql = "CREATE TABLE IF NOT EXISTS CINEMA_LIFE.SHOW_TIME "
                    + " ( "
                    + " ID                        SERIAL PRIMARY KEY      NOT NULL, "
                    + " SCREEN_ID                 INT                     NOT NULL, "
                    + " FILM_ID                   INT                     NOT NULL, "
                    + " DATE_TIME                 TIMESTAMP               NOT NULL  "
                    + " ) ";
            stmt.executeUpdate(sql);



            sql = "ALTER TABLE CINEMA_LIFE.SHOW_TIME "
                    + " ADD CONSTRAINT FK_SCREEN "
                    + " FOREIGN KEY ( SCREEN_ID ) REFERENCES CINEMA_LIFE.SCREEN (ID) MATCH FULL "
                    + " ";
            stmt.executeUpdate(sql);



            sql = "ALTER TABLE CINEMA_LIFE.SHOW_TIME "
                    + " ADD CONSTRAINT FK_FILM "
                    + " FOREIGN KEY ( FILM_ID ) REFERENCES CINEMA_LIFE.FILM (ID) MATCH FULL "
                    + " ";
            stmt.executeUpdate(sql);



            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Schema and tables are created successfully");
    }
}
