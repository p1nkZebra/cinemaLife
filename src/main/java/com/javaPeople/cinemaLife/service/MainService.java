package com.javaPeople.cinemaLife.service;

import com.javaPeople.cinemaLife.domain.Cinema;
import com.javaPeople.cinemaLife.domain.Screen;

import java.util.Arrays;
import java.util.List;

public class MainService {

    public static void main(String[] args) {



        CinemaService cinemaService = new CinemaService();

        Cinema cinema = cinemaService.findById(1L);
        System.out.println(cinema);




        ScreenService screenService = new ScreenService();

        List<Screen> screenList = screenService.findByCinemaName("Пять Звезд");
        System.out.println(Arrays.toString(screenList.toArray()));
    }
}
