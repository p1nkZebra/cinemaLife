package com.javaPeople.cinemaLife.dao;

import com.javaPeople.cinemaLife.db.DbConfig;
import com.javaPeople.cinemaLife.domain.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    public List<Film> getFilmList() {
        Connection connection = null;
        Statement statement = null;
        List<Film> filmList = new ArrayList<>();


        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    DbConfig.DB_PASSWORD
            );
            statement = connection.createStatement();
            sql = "SELECT * FROM CINEMA_LIFE.FILM";
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String director = resultSet.getString("director");
                Integer year = resultSet.getInt("year");

                Film film = new Film(id, name, director, year);
                filmList.add(film);

            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return filmList;
    }
}
