package com.mrhuytran.threads;

import com.mrhuytran.users.User;
import java.util.ArrayList;

public class Post extends Thread {

     private String title;
     private String header;
     private ArrayList<String> tags;
     private int views;
     private ArrayList<Thread> followUps;

     public Post() {
         super();
         title = null;
         header = null;
         tags = null;
         views = 0;
         followUps = null;
     }

     public Post(User poster, String body, String title, String header) {
         super(poster, body);
         this.title = title;
         this.header = header;
         tags = new ArrayList<String>();
         this.views = 0;
         followUps = new ArrayList<Thread>();
     }

    public Post(User poster, String body, String title, String header, ArrayList<String> tags, int views, ArrayList<Thread> followUps) {
        super(poster, body);
        this.title = title;
        this.header = header;
        this.tags = tags;
        this.views = views;
        this.followUps = followUps;
    }

     public String getTitle() {
         return title;
     }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
         tags.add(tag);
    }

    public void removeTag(String tag) {
         tags.remove(tag);
    }

    public int getViews() {
        return views;
    }

    //increment view by 1
    public void addView() {
         views++;
    }

    public ArrayList<Thread> getFollowUps() {
        return followUps;
    }

    public void addFollowUp(FollowUp followUp) {
         followUps.add(followUp);
    }

    //*************
    //would need to implement this careful by overriding equals() and hashcode()
    public void removeFollowUp(FollowUp followUp) {
         followUps.remove(followUp);
    }
}
