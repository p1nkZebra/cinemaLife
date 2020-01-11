package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.FilmDao;
import com.javaPeople.cinemaLife.domain.Film;
import java.util.List;

public class FilmService {

    public List<Film> getFilmList(){
        FilmDao filmDao = new FilmDao();
        List<Film> filmList = filmDao.getFilmList();
        return filmList;
    }

    public void printFilmList(){
        List<Film> FilmList = getFilmList();
        for (Film film:FilmList) {
            System.out.println( film.getName() +" " +  film.getDirector() + " " + film.getYear());
        }
    }
}
