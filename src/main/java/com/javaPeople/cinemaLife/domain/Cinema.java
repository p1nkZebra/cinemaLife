package com.javaPeople.cinemaLife.domain;

import java.util.StringJoiner;

public class Cinema {

    private Long id;
    private String name;
    private String city;

    public Cinema(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Cinema.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("city='" + city + "'")
                .toString();

    }
}
