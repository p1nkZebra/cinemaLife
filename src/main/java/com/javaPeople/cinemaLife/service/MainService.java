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

public class MainService {

    public static void main(String[] args) throws IOException, URISyntaxException, DocumentException, SAXException, ParserConfigurationException {

        TicketService ticketService = new TicketService();
        ticketService.printTicket(254L);
        ticketService.printTicket(34L);
        ShowTimeService showTimeService = new ShowTimeService();
        LocalDate date = LocalDate.of(2019, 12, 21);
        showTimeService.printShowTimeForDate(date);
////        LocalDateTime dateTime = date.atTime(3,0);
////        LocalDateTime dateTime2 = dateTime.plusHours(20);
////        System.out.println(dateTime2.toString());

//        showTimeService.printShowTimeForDate(dateTime, dateTime2);
    }
}
