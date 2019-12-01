package com.mrhuytran.users;

import java.util.GregorianCalendar;

public class User {

    private String name;
    private int points;
    private GregorianCalendar dateJoined;

    public User() {
        name = null;
        points = 0;
        dateJoined = null;
    }
    public User(String name, int points) {
        this.name = name;
        this.points = points;
        dateJoined = new GregorianCalendar();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    //increment points by 1
    public void addPoint() {
        points++;
    }

    //increment points by multiple
    public void addPoints(int points) {
        this.points += points;
    }

    public GregorianCalendar getDateJoined() {
        return dateJoined;
    }
}
