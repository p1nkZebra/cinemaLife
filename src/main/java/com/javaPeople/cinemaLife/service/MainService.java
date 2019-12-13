package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;

import java.time.LocalDate;

public class MainService {

    public static void main(String[] args) {



//
//
//        Cinema cinema = cinemaService.findById(1L);
//        Cinema cinema1 = cinemaService.findByName("Звезд");
//        Cinema cinema2 = new Cinema(7L,"Осмос", "New Jersey");
//        Cinema cinema3 = new Cinema(100L,"Vegan","NY");
//
////        CinemaService.save(cinema2);
//            CinemaService.save(cinema3);
//        System.out.println(cinema3);
////        System.out.println(cinema);
//
//
//        ScreenService screenService = new ScreenService();
//
//        List<Screen> screenList = screenService.findByCinemaName("Пять Звезд");
////        System.out.println(Arrays.toString(screenList.toArray()));
//
//        for (Screen item : screenList ) {
//            System.out.println(item);
//        }

        CinemaService cinemaService = new CinemaService();
        Cinema cinema2 = new Cinema(7L,"Осмос", "New Jersey");
        cinemaService.save(cinema2);

        ShowTimeService showTimeService = new ShowTimeService();
        showTimeService.printShowTimeForDate(LocalDate.parse("2019-12-20"));



    }
}
