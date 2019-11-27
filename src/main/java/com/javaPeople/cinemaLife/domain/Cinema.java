package com.javaPeople.cinemaLife.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Cinema {

    private Long id;
    private String name;
    private String city;



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
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("city", city)
                .toString();
    }
}
