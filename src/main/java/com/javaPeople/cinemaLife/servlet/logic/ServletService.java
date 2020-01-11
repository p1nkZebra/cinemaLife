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

    public List<ShowTimeDto> getShowTimeDtoList() {

        ShowTimeService showTimeService = new ShowTimeService();
        LocalDate date = LocalDate.of(2019, 12, 20);
        Timestamp from = showTimeService.convertToTimeStamp(date.atStartOfDay());
        Timestamp to = showTimeService.convertToTimeStamp(date.plusDays(1).atStartOfDay());
        ShowTimeDao dao = new ShowTimeDao();
        List<ShowTimeDto> showTimeDtoList = dao.findShowTimeDtosBetweenDateTimes(from, to);

        return showTimeDtoList;
    }
}
