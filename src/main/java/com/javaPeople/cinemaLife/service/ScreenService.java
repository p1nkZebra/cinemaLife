package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.ScreenDao;
import com.javaPeople.cinemaLife.db.DbConfig;
import com.javaPeople.cinemaLife.domain.Screen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;

public class ScreenService {

    public List<Screen> findByCinemaName(String cinemaName) {

        List<Screen> screenList = new ArrayList<>();

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

            sql = "SELECT * FROM CINEMA_LIFE.SCREEN " +
                    " WHERE CINEMA_ID = ( SELECT ID FROM CINEMA_LIFE.CINEMA WHERE NAME = ? ) ";

            statement = connection.prepareStatement(sql);
            statement.setString(1, cinemaName);


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
                long cinemaId = resultSet.getLong("cinema_id");
                String name = resultSet.getString("name");
                int rows = resultSet.getInt("rows");
                int seatsInRow = resultSet.getInt("seats_in_row");



                Screen screen = new Screen(id, cinemaId, name, rows, seatsInRow);
                screenList.add(screen);

            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return screenList;
    }

    public Screen findById(Long screenId) {

        Screen screen = null;

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

            sql = "SELECT * FROM CINEMA_LIFE.SCREEN WHERE ID = ?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, screenId.intValue());


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                long id = resultSet.getLong("id");
                long cinemaId = resultSet.getLong("cinemaId");
                String name = resultSet.getString("name");
                int rows = resultSet.getInt("rows");
                int seatsInRow = resultSet.getInt("seats_In_Row");



                screen = new Screen(id, cinemaId, name, rows, seatsInRow);
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return screen;
    }

    public  void save (Screen screen) {

        CinemaService cs = new CinemaService();
        if (cs.findById(screen.getCinemaId()) == null) {
            System.out.println("Не корректный Cinema_id");
            return;
        }

        ScreenDao dao = new ScreenDao();
        dao.save(screen);
    }

    public List<String> getCinemaListByCapacity (int viewersAmount) {

        ScreenDao dao = new ScreenDao();
        return dao.findCinemaListByCapacity(viewersAmount);
    }



}
