package com.mrhuytran.users;

public class Student extends User {

    private boolean anonymous;
    private String faculty;

    public Student() {
        super();
        anonymous = false;
        faculty = null;
    }

    public Student(String name, int points, boolean anonymous, String faculty) {
        super(name, points);
        this.anonymous = anonymous;
        this.faculty = faculty;
    }

    public boolean getAnonymity() {
        return anonymous;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
