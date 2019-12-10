package com.javaPeople.cinemaLife.dto;

import java.time.LocalDateTime;

public class ShowTimeDto {

    private Long id;
    private String filmName;
    private String screenName;
    private LocalDateTime dateTime;

    public ShowTimeDto(Long id, String filmName, String screenName, LocalDateTime dateTime) {
        this.id = id;
        this.filmName = filmName;
        this.screenName = screenName;
        this.dateTime = dateTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
