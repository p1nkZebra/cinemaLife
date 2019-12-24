package com.javaPeople.cinemaLife.domain;


import java.util.StringJoiner;

public class Ticket {

    private Long id;
    private Long showtimeId;
    private int row;
    private int seat;

    public Ticket(Long id, Long showtimeId, int row, int seat) {
        this.id = id;
        this.showtimeId = showtimeId;
        this.row = row;
        this.seat = seat;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getShowtimeId() { return showtimeId; }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getRow() { return row; }

    public void setRow(int row) { this.row = row; }

    public int getSeat() { return seat; }

    public void setSeat(int seat) { this.seat = seat; }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ticket.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("showtimeId=" + showtimeId)
                .add("row=" + row)
                .add("seat=" + seat)
                .toString();
    }
}
