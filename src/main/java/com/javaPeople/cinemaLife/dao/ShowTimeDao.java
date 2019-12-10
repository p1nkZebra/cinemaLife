package com.javaPeople.cinemaLife.dao;

import com.javaPeople.cinemaLife.db.DbConfig;
import com.javaPeople.cinemaLife.domain.ShowTime;
import com.javaPeople.cinemaLife.dto.ShowTimeDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowTimeDao {


    public List<ShowTime> findBetweenDateTimes(Timestamp dateTimeFrom,
                                               Timestamp dateTimeTo) {


        List<ShowTime> showTimeList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    DbConfig.DB_PASSWORD
            );

            sql = "   SELECT * " +
                    " FROM CINEMA_LIFE.SHOW_TIME " +
                    " WHERE 1 = 1 " +
                    "       AND DATE_TIME BETWEEN ? AND ? ";

            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, dateTimeFrom);
            statement.setTimestamp(2, dateTimeTo);


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
                long screenId = resultSet.getLong("screen_id");
                long filmId = resultSet.getLong("film_id");
                Timestamp dateTime = resultSet.getTimestamp("date_time");

                ShowTime showTime = new ShowTime(id, filmId, screenId, dateTime.toLocalDateTime());
                showTimeList.add(showTime);

            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return showTimeList;
    }




    public List<ShowTimeDto> findShowTimeDtosBetweenDateTimes(Timestamp dateTimeFrom,
                                                              Timestamp dateTimeTo) {


        List<ShowTimeDto> showTimeList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    DbConfig.DB_PASSWORD
            );

            sql = "   SELECT a.*, b.name  as film_name " +
                    " FROM cinema_life.show_time a" +
                    " JOIN  cinema_life.film b ON (a.film_id = b.id)" +
                    " WHERE 1 = 1 " +
                    "       AND a.date_time between ? AND ? ";

            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, dateTimeFrom);
            statement.setTimestamp(2, dateTimeTo);


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
//                long screenId = resultSet.getLong("screen_name");
                String filmName = resultSet.getString("film_name");
                Timestamp dateTime = resultSet.getTimestamp("date_time");

                ShowTimeDto showTimeDto = new ShowTimeDto(id, filmName, "test", dateTime.toLocalDateTime());
                showTimeList.add(showTimeDto);

            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return showTimeList;
    }
}
