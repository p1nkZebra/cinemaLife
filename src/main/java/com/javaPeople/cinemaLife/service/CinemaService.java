package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.CinemaDao;
import com.javaPeople.cinemaLife.domain.Cinema;

public class CinemaService {


    public Cinema findCinemaById(Long cinemaId) {
        CinemaDao dao = new CinemaDao();
        return dao.findCinemaById(cinemaId);
    }


    public  Cinema findCinemaByName(String cinemaName) {
        CinemaDao dao = new CinemaDao();
        return dao.findCinemaByName(cinemaName);
    }


    public  void save (Cinema cinema) {
        CinemaDao dao = new CinemaDao();
        dao.saveCinema(cinema);
    }

}
