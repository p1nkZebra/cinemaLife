package com.javaPeople.cinemaLife.servlet.logic;

public class ServletService {
    public String getGreeting() {
        return "Ку!";
    }

    public String getGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Ку! Ку!";
        }

        return "Ку! " + name;
    }
}
