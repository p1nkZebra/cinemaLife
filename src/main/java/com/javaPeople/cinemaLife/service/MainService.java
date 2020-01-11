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

//        TicketService ticketService = new TicketService();
//        ticketService.printTicket(254L);
//        ticketService.printTicket(34L);
//        Cinema cinema = new CinemaService().findById(15L);
//        ShowTimeService showTimeService = new ShowTimeService();
//        LocalDate date = LocalDate.of(2019, 12, 20);
//        if (cinema!=null) {
//            showTimeService.printShowTimeForCinemaByDate(date,cinema);
//        }
//        else {
//            System.out.println("Нет такого Кинотеатра");
//        }

        CinemaService cs=new CinemaService();
//        System.out.println(cs.findCinemaByName("MovieCinema").getName());
        cs.save(new Cinema(4L,"New Cinema", "Saint P" ));
    }
}
