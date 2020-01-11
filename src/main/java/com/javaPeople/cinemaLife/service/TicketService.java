package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.dao.TicketDao;
import com.javaPeople.cinemaLife.domain.Ticket;

public class TicketService {

    public void save (Ticket ticket) {
        TicketDao dao = new TicketDao();
        dao.save(ticket);
    }

}
