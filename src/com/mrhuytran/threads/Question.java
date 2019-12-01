package com.mrhuytran.threads;

import com.mrhuytran.users.User;
import java.util.ArrayList;

public class Question extends Post {

    private ArrayList<Thread> answers;

    public Question() {
        super();
        answers = null;
    }

    public Question(User poster, String body, String title, String header) {
        super(poster, body, title, header);
        answers = new ArrayList<Thread>();
    }

    public ArrayList<Thread> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    //*************
    //would need to implement this careful by overriding equals() and hashcode()
    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }
}
