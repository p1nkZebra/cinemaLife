package com.javaPeople.cinemaLife.dao;

import com.javaPeople.cinemaLife.db.DbConfig;
import com.javaPeople.cinemaLife.domain.Screen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScreenDao {
   
    public void save(Screen screen) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "";

        System.out.println("Попробуем сохранить запись");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    DbConfig.DB_PASSWORD
            );

            sql = "INSERT INTO CINEMA_LIFE.SCREEN (CINEMA_ID, NAME, ROWS, SEATS_IN_ROW)" +
                    "VALUES (?, ? ,? ,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, screen.getCinemaId());
            statement.setString(2, screen.getName());
            statement.setInt(3, screen.getRows());
            statement.setInt(4, screen.getSeatsInRow());
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }


    public List<String> findCinemaListByCapacity(int viewersAmount) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<String> cinemaNameList = new ArrayList<>();
        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    DbConfig.DB_PASSWORD
            );

            sql = "   SELECT b.name as cinema_name " +
                    " FROM cinema_life.screen as a" +
                    " JOIN  cinema_life.cinema as b ON (a.cinema_id = b.id)"+
                    " WHERE 1 = 1 " +
                    "       AND a.rows*a.seats_in_row > ? " +
                    "       GROUP BY cinema_name";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, viewersAmount);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                cinemaNameList.add(rs.getString("cinema_name"));
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return cinemaNameList;

    }
}
