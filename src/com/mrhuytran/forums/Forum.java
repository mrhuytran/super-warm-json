package com.mrhuytran.forums;

import com.mrhuytran.threads.Note;
import com.mrhuytran.threads.Question;

import java.util.ArrayList;

public class Forum {

    private String title;
    private ArrayList<Question> questions;
    private ArrayList<Note> notes;
    private String description;

    public Forum() {
        title = null;
        questions = null;
        notes = null;
        description = null;
    }

    public Forum(String title, String description) {
        this.title = title;
        this.description = description;
        questions = new ArrayList<Question>();
        notes = new ArrayList<Note>();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    //*************
    //would need to implement this careful by overriding equals() and hashcode()
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    //*************
    //would need to implement this careful by overriding equals() and hashcode()
    public void removeNote(Note note) {
        notes.remove(note);
    }

    public String getDescription() {
        return description;
    }
}
