package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CinemaService {


    public Cinema findById(Long cinemaId) {

        Cinema cinema = null;

        System.out.println("Ищем cinema по ID");
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


    public  Cinema findByName(String cinemaName) {
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
                sql = "SELECT * FROM CINEMA_LIFE.CINEMA WHERE name =" + cinemaName ;

                ResultSet resultSet = stmt.executeQuery(sql);

                while (resultSet.next()) {
                    // Now we can fetch the data by column name, save and use them!
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String city = resultSet.getString("city");

                    cinema = new Cinema(id, name, city);
                    System.out.println(cinema);
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



    public  void save (Cinema cinema) {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "3$Jf&z#9d*&2"
            );


               sql = "INSERT INTO CINEMA_LIFE.CINEMA (NAME, CITY)" +
                        "VALUES (? ,?)";
               statement = connection.prepareStatement(sql);

                statement.setString(1, cinema.getName());
                statement.setString(2, cinema.getCity());
                statement.executeUpdate();
                System.out.println(statement);

            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }




    }

}
