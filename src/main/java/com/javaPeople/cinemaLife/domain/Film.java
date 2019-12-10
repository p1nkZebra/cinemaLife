package com.javaPeople.cinemaLife.domain;

import java.util.StringJoiner;

public class Film {

    private Long id;
    private String name;
    private String director;
    private Integer year;

    public Film(Long id, String name, String director, Integer year) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Film.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("director='" + director + "'")
                .add("year=" + year)
                .toString();
    }
}
