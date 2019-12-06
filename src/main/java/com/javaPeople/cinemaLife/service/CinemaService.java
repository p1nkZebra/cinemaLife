package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CinemaService {


    public static void main(String[] args) {

        Cinema cinema = getFirstFromCinemaTable();


        System.out.println(cinema.toString());



    }

    private static Cinema getFirstFromCinemaTable() {

        Cinema cinema = null;

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


            sql = "SELECT * FROM CINEMA_LIFE.CINEMA WHERE ID = 1 ";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");

                cinema = createNewCinema(id, name, city);
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

    private static Cinema createNewCinema(long id,
                                          String name,
                                          String city) {
        Cinema result = new Cinema();

        result.setId(id);
        result.setName(name);
        result.setCity(city);

        return result;

    }
}
