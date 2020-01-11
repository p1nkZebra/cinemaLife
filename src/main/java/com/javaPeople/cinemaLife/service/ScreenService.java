package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.ScreenDao;
import com.javaPeople.cinemaLife.domain.Screen;

import java.util.List;

public class ScreenService {

    public List<Screen> getScreenListForCinemaName(String cinemaName) {
        ScreenDao dao = new ScreenDao();
        return dao.getScreenListForCinemaName(cinemaName);
    }

    public Screen findById(Long screenId) {
        ScreenDao dao = new ScreenDao();
        return dao.findScreenById(screenId);
    }


    public  void save (Screen screen) {
        CinemaService cs = new CinemaService();
        if (cs.findCinemaById(screen.getCinemaId()) == null) {
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
