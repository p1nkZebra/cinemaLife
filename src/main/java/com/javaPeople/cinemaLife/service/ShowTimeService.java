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

        LocalDateTime dateTimeFrom = date.atTime(9,0);
        LocalDateTime dateTimeTo = date.plusDays(1).atTime(3,0);

        printShowTimeForDatetimePeriod(
                convertToTimeStamp(dateTimeFrom),
                convertToTimeStamp(dateTimeTo)
        );
    }

    public void printShowTimeForDate(LocalDateTime from, LocalDateTime to) {
        printShowTimeForDatetimePeriod(
                convertToTimeStamp(from),
                convertToTimeStamp(to)
        );
    }

    private void printShowTimeForDatetimePeriod(Timestamp from, Timestamp to) {

        ShowTimeDao dao = new ShowTimeDao();
        List<ShowTimeDto> showTimeDtoList = dao.findShowTimeDtosBetweenDateTimes(from, to);

        for (ShowTimeDto st : showTimeDtoList) {
            System.out.println(st.getDateTime() + " - film: " + st.getFilmName() + " - screen: " + st.getScreenName());
        }

        System.out.println("take a pause");
    }

//    public void printShowTimeForCinemaByDate(LocalDate date) {
//        ShowTimeDao dao = new ShowTimeDao();
//        List<ShowTimeDto> showTimeDtoList = dao.findShowTimeDtosBetweenDateTimes();
//
//        for (ShowTimeDto st : showTimeDtoList) {
//            System.out.println(st.getDateTime() + " - film: " + st.getFilmName() + " - screen: " + st.getScreenName());
//        }
//    }

    private Timestamp convertToTimeStamp(LocalDateTime dateTimeFrom) {
        return Timestamp.valueOf(dateTimeFrom);
    }
}
