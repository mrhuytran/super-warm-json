package com.mrhuytran.threads;

import com.mrhuytran.users.User;
import java.util.GregorianCalendar;

public class Thread {

    private User poster;
    private String body;
    private GregorianCalendar datePosted;

    public Thread() {
        poster = null;
        body = null;
        datePosted = null;
    }

    public Thread(User poster, String body) {
        this.poster = poster;
        this.body = body;
        datePosted = new GregorianCalendar();
    }

    public Thread(User poster, String body, GregorianCalendar datePosted) {
        this.poster = poster;
        this.body = body;
        this.datePosted = datePosted;
    }

    public User getPoster() {
        return poster;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public GregorianCalendar getDatePosted() {
        return datePosted;
    }
}
