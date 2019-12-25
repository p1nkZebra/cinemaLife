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
import java.util.Arrays;

public class MainService {

    public static void main(String[] args) throws IOException, URISyntaxException, DocumentException, SAXException, ParserConfigurationException {

        TicketService ticketService = new TicketService();
        ticketService.printTicket(14L);
        //Ticket ticket = new Ticket(3L,1L,10,15);
        //ticketService.save(ticket);

//        Ticket ticket1 = new Ticket(3L,4L,12,25);
//        ticketService.save(ticket1);
    }
}
