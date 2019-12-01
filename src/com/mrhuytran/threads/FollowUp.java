package com.mrhuytran.threads;

import com.mrhuytran.users.User;

public class FollowUp extends Thread {

    public FollowUp() {
        super();
    }

    public FollowUp(User poster, String body) {
        super(poster, body);
    }
}
