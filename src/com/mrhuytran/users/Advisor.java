package com.mrhuytran.users;

public class Advisor extends User {

    private String occupation;
    private String degree;

    public Advisor() {
        super();
        occupation = null;
        degree = null;
    }

    public Advisor(String name, int points, String occupation, String degree) {
        super(name, points);
        this.occupation = occupation;
        this.degree = degree;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
