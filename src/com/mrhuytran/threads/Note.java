package com.mrhuytran.threads;

import com.mrhuytran.users.User;

public class Note extends Post {

    public Note() {
        super();
    }

    public Note(User poster, String body, String title, String header) {
        super(poster, body, title, header);
    }
}
