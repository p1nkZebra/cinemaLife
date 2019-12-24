package com.javaPeople.cinemaLife.dao;

import com.javaPeople.cinemaLife.db.DbConfig;
import com.javaPeople.cinemaLife.domain.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TicketDao {
    public void save(Ticket ticket) {
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

            sql = "INSERT INTO CINEMA_LIFE.TICKET (SHOWTIME_ID, ROW, SEAT)" +
                    "VALUES (? ,? ,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, ticket.getShowtimeId());
            statement.setInt(2, ticket.getRow());
            statement.setInt(3, ticket.getSeat());
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

}
