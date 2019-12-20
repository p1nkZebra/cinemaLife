package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;
import com.javaPeople.cinemaLife.domain.Screen;

import java.time.LocalDate;

public class MainService {

    public static void main(String[] args) {


//        List<Screen> screenList = screenService.findByCinemaName("Пять Звезд");
////        System.out.println(Arrays.toString(screenList.toArray()));
//
//        for (Screen item : screenList ) {
//            System.out.println(item);
//        }

        CinemaService cinemaService = new CinemaService();
        ScreenService screenService = new ScreenService();
        Screen screen1 = new Screen(3L,4L,"Big Dayse", 12,24);
        screenService.save(screen1);
//        Cinema cinema2 = new Cinema(7L,"Осмос", "New Jersey");
//          cinemaService.save(cinema2);
//        System.out.println(cinema2.toString());
//        ShowTimeService showTimeService = new ShowTimeService();
//        showTimeService.printShowTimeForDate(LocalDate.parse("2019-12-20"));



    }
}
