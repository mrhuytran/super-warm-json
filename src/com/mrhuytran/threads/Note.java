package com.mrhuytran.threads;

import com.mrhuytran.users.User;

import java.util.ArrayList;

public class Note extends Post {

    public Note() {
        super();
    }

    public Note(User poster, String body, String title, String header) {
        super(poster, body, title, header);
    }

    public Note(User poster, String body, String title, String header,
                ArrayList<String> tags, int views, ArrayList<Thread> followUps) {
        super(poster, body, title, header, tags, views, followUps);
    }
}
