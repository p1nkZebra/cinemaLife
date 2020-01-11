package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.ShowTimeDao;
import com.javaPeople.cinemaLife.domain.Cinema;
import com.javaPeople.cinemaLife.domain.ShowTime;
import com.javaPeople.cinemaLife.dto.ShowTimeDto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShowTimeService {

    public List<ShowTimeDto> getShowTimeForDate(LocalDate date) {

        LocalDateTime dateTimeFrom = date.atTime(0,0);
        LocalDateTime dateTimeTo = date.plusDays(1).atTime(0,0);
        return  getShowTimeForPeriod(dateTimeFrom, dateTimeTo);

    }

    public List<ShowTimeDto> getShowTimeForPeriod(LocalDateTime from, LocalDateTime to) {
        return getShowTimeForDatetimePeriod(
                convertToTimeStamp(from),
                convertToTimeStamp(to)
        );
    }


    public void printShowTimeForDate(LocalDate date) {
        List<ShowTimeDto> showTimeDtoList = getShowTimeForDate(date);
        System.out.println("Дата: " + date );
        System.out.println("Сеансы: ");
        String printRecord;
        for (ShowTimeDto st : showTimeDtoList) {
            printRecord =
                    "  " +st.getDateTime().toLocalTime() + "  \"" + st.getFilmName() +
                    "\"" + "    [cinema: " + "\"" + st.getCinemaName() + "\"" +
                    " - screen: " + "\"" + st.getScreenName()+ "\"]";
            System.out.println(printRecord);
        }
    }


    public void printShowTimeForPeriod(LocalDateTime from, LocalDateTime to) {
        List<ShowTimeDto> showTimeDtoList = getShowTimeForPeriod(from,to);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("ddMMM HH:mm");
        System.out.println("Период:  с  " + from.format(f) + " по " + to.format(f));
        System.out.println("Сеансы: ");
        String printRecord;
        for (ShowTimeDto st : showTimeDtoList) {
            printRecord =
                    "  "+st.getDateTime().format(f) + "  \"" + st.getFilmName() +
                    "\"" + "    [cinema: " + "\"" + st.getCinemaName() +
                    "\"" +  " - screen: " +  "\""+ st.getScreenName()+ "\"]";
            System.out.println(printRecord);
        }
    }



    private List<ShowTimeDto> getShowTimeForDatetimePeriod(Timestamp from, Timestamp to) {

        ShowTimeDao dao = new ShowTimeDao();
        List<ShowTimeDto> showTimeDtoList = dao.findShowTimeDtosBetweenDateTimes(from, to);
        return showTimeDtoList;
    }

    public List<ShowTimeDto> getShowTimeForCinemaByDate(LocalDate date, String cinemaName) {
        List<ShowTimeDto> showTimeDtoList = getShowTimeForDate(date);
        List<ShowTimeDto> showTimeForCinema = new ArrayList<>();
        for (ShowTimeDto st : showTimeDtoList) {
            if (cinemaName.equals(st.getCinemaName())) {
                showTimeForCinema.add(st);
            }
        }
        return showTimeForCinema;
    }


    public void printShowTimeForCinemaByDate(LocalDate date, String cinemaName) {
        List<ShowTimeDto> showTimeDtoList = getShowTimeForCinemaByDate(date,cinemaName);
        System.out.println("\nКинотеатр: " + cinemaName);
        System.out.println("Дата: " + date );
        String printRecord;
        for (ShowTimeDto st : showTimeDtoList) {
            if (cinemaName.equals(st.getCinemaName())) {
                printRecord =
                        "  "+ st.getDateTime().toLocalTime() + "   film: " +
                        "\"" + st.getFilmName() + "\"" + " - Screen: " +
                        "\"" + st.getScreenName()+ "\"";
                System.out.println(printRecord);
            }
        }
    }

    public Timestamp convertToTimeStamp(LocalDateTime dateTimeFrom) {
        return Timestamp.valueOf(dateTimeFrom);
    }
}
