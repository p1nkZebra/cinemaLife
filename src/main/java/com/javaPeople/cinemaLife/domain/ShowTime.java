package com.javaPeople.cinemaLife.domain;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class ShowTime {

    private Long id;
    private Long filmId;
    private Long screenId;
    private LocalDateTime dateTime;


    public ShowTime(Long id, Long filmId, Long screenId, LocalDateTime dateTime) {
        this.id = id;
        this.filmId = filmId;
        this.screenId = screenId;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", ShowTime.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("filmId=" + filmId)
                .add("screenId=" + screenId)
                .add("dateTime=" + dateTime)
                .toString();
    }
}
