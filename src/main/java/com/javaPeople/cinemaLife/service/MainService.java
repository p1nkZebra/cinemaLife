package com.javaPeople.cinemaLife.service;

import com.itextpdf.text.DocumentException;
import com.javaPeople.cinemaLife.domain.Cinema;
import com.javaPeople.cinemaLife.domain.Screen;
import com.javaPeople.cinemaLife.domain.Ticket;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class MainService {

    public static void main(String[] args) throws IOException, URISyntaxException, DocumentException, SAXException, ParserConfigurationException {

        ShowTimeService showTimeService = new ShowTimeService();
        LocalDate date = LocalDate.of(2019, 12, 20);
//        showTimeService.printShowTimeForPeriod(date.atStartOfDay(), date.plusDays(1).atStartOfDay());


        Cinema cinema = new CinemaService().findCinemaById(1L);
        showTimeService.printShowTimeForDate(date);
        showTimeService.printShowTimeForCinemaByDate(date,"Рекорд Звезд");


    }
}
