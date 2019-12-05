package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CinemaService {


    public Cinema findById(Long cinemaId) {

        Cinema cinema = null;

        Connection c = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "123"
            );

            stmt = c.createStatement();


            sql = "SELECT * FROM CINEMA_LIFE.CINEMA WHERE ID = " + cinemaId;
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");

                cinema = new Cinema(id, name, city);
            }

            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return cinema;

    }

    public Cinema findByName(String cinemaName) {
        //todo

        return null;
    }

    public Cinema save(Cinema cinema) {
        //todo

        return null;
    }

}
