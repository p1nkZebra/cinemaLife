package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.ShowTimeDao;
import com.javaPeople.cinemaLife.domain.ShowTime;
import com.javaPeople.cinemaLife.dto.ShowTimeDto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ShowTimeService {

    public void printShowTimeForDate(LocalDate date) {

        ShowTimeDao dao = new ShowTimeDao();

        LocalDateTime dateTimeFrom = date.atTime(9,0);
        Timestamp from = Timestamp.valueOf(dateTimeFrom);
        LocalDateTime dateTimeTo = date.plusDays(1).atTime(3,0);
        Timestamp to = Timestamp.valueOf(dateTimeTo);


//        List<ShowTime> showTimeList = dao.findBetweenDateTimes(from, to);
//
//        for (ShowTime st : showTimeList) {
//            System.out.println(st.getDateTime() + " - filmId: " + st.getFilmId() + " - screenId: " + st.getScreenId());
//        }



        List<ShowTimeDto> showTimeDtoList = dao.findShowTimeDtosBetweenDateTimes(from, to);

        for (ShowTimeDto st : showTimeDtoList) {
            System.out.println(st.getDateTime() + " - film: " + st.getFilmName() + " - screen: " + st.getScreenName());
        }


    }
}
