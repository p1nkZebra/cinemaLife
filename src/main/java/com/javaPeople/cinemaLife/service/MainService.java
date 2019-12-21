package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;
import com.javaPeople.cinemaLife.domain.Screen;

import java.time.LocalDate;
import java.util.Arrays;

public class MainService {

    public static void main(String[] args) {


        CinemaService cinemaService = new CinemaService();
        ScreenService screenService = new ScreenService();
//        Screen screen1 = new Screen(3L,3L,"Middle Dayse", 22,34);
//        screenService.save(screen1);
        System.out.println(Arrays.toString(screenService.getCinemaListByCapacity(300).toArray()));
//        Cinema cinema2 = new Cinema(7L,"Осмос", "New Jersey");
//          cinemaService.save(cinema2);
//        System.out.println(cinema2.toString());
       // ShowTimeService showTimeService = new ShowTimeService();
        //showTimeService.printShowTimeForCinema(LocalDate.parse("2019-12-21"),"Рекорд Звезд");



    }
}
