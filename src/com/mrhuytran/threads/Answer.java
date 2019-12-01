package com.mrhuytran.threads;

import com.mrhuytran.users.User;

public class Answer extends Thread {

    public Answer() {
        super();
    }

    public Answer(User poster, String body) {
        super(poster, body);
    }
}
