package com.javaPeople.cinemaLife.servlet.logic;

import com.javaPeople.cinemaLife.dao.ShowTimeDao;
import com.javaPeople.cinemaLife.domain.Cinema;
import com.javaPeople.cinemaLife.dto.ShowTimeDto;
import com.javaPeople.cinemaLife.service.CinemaService;
import com.javaPeople.cinemaLife.service.ShowTimeService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class ServletService {
    public String getGreeting() {
        return "Ку!";
    }

    public String getGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Ку! Ку!";
        }

        return "Ку! " + name;
    }

    public List<ShowTimeDto> getShowTimeDtoList(LocalDate date) {
        List<ShowTimeDto> showTimeList= new ShowTimeService().getShowTimeForDate(date);
        return showTimeList;
    }

    public List<ShowTimeDto> getShowTimeForCinema(LocalDate date, String cinemaName) {
        List<ShowTimeDto> showTimeList= new ShowTimeService().getShowTimeForCinemaByDate(date,cinemaName);
        return showTimeList;
    }
}
