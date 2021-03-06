package com.javaPeople.cinemaLife.domain;

import java.util.StringJoiner;

public class Screen {

    private Long id;
    private Long cinemaId;
    private String name;
    private Integer rows;
    private Integer seatsInRow;


    public Screen(Long id, Long cinemaId, String name, Integer rows, Integer seatsInRow) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.name = name;
        this.rows = rows;
        this.seatsInRow = seatsInRow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getSeatsInRow() {
        return seatsInRow;
    }

    public void setSeatsInRow(Integer seatsInRow) {
        this.seatsInRow = seatsInRow;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Screen.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cinemaId=" + cinemaId)
                .add("name='" + name + "'")
                .add("rows=" + rows)
                .add("seatsInRow=" + seatsInRow)
                .toString();
    }
}
