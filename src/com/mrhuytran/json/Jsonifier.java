package com.mrhuytran.json;

import com.mrhuytran.forums.Forum;
import com.mrhuytran.threads.Thread;
import com.mrhuytran.threads.*;
import com.mrhuytran.users.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.GregorianCalendar;
import java.util.List;

public class Jsonifier {

    //helper function
    private static JSONObject datePostedToJson(GregorianCalendar date) {
        JSONObject datePostedJSON = new JSONObject();

        //make a JSON object
        datePostedJSON.put("year", date.get(GregorianCalendar.YEAR));
        datePostedJSON.put("month", date.get(GregorianCalendar.MONTH));
        datePostedJSON.put("day", date.get(GregorianCalendar.DAY_OF_MONTH));
        datePostedJSON.put("hour", date.get(GregorianCalendar.HOUR_OF_DAY));
        datePostedJSON.put("minute", date.get(GregorianCalendar.MINUTE));

        return datePostedJSON;
    }

    //helper function
    private static JSONObject threadToJson(Thread t) {
        JSONObject threadJSON = new JSONObject();

        //make a JSON object
        threadJSON.put("poster", t.getPoster().getName());
        threadJSON.put("poster-points", t.getPoster().getPoints());
        threadJSON.put("body", t.getBody());
        threadJSON.put("date-posted", datePostedToJson(t.getDatePosted()));

        return threadJSON;
    }

    //helper function
    private static JSONArray threadListToJson(List<Thread> threads) {
        JSONArray threadListJSON = new JSONArray();

        //make a JSON array
        for (Thread t : threads) {
            threadListJSON.put(threadToJson(t));
        }

        return threadListJSON;
    }

    //helper function
    private static JSONObject tagToJson(String t) {
        JSONObject tagJSON = new JSONObject();

        //make a JSON object
        tagJSON.put("tag", t);
        return tagJSON;
    }

    //helper function
    private static JSONArray tagListToJson(List<String> tags) {
        JSONArray tagListJSON = new JSONArray();

        //make a JSON array
        for (String tag : tags) {
            tagListJSON.put(tagToJson(tag));
        }

        return tagListJSON;
    }

    private static JSONObject postToJson(Post p) {
        JSONObject postJSON = new JSONObject();

        //make a JSON object
        postJSON.put("thread", threadToJson(p));
        postJSON.put("title", p.getTitle());
        postJSON.put("header", p.getHeader());
        postJSON.put("tags", tagListToJson(p.getTags())); //see implementation above
        postJSON.put("views", p.getViews());
        postJSON.put("follow-ups", threadListToJson(p.getFollowUps())); //see implementation above

        return postJSON;
    }

    //helper function
    private static JSONObject questionToJson(Question q) {
        JSONObject questionJSON = new JSONObject();

        //make a JSON object
        questionJSON.put("question", postToJson(q));
        questionJSON.put("answers", threadListToJson(q.getAnswers()));

        return questionJSON;
    }

    //helper function
    private static JSONObject noteToJson(Note n) {
        JSONObject noteJSON = new JSONObject();

        //make a JSON object
        noteJSON.put("note", postToJson(n));

        return noteJSON;
    }

    private static JSONArray questionListToJson(Forum f) {
        JSONArray questionListJSON = new JSONArray();
        List<Question> questions = f.getQuestions();

        //make a JSON array
        for (Question q : questions) {
            questionListJSON.put(questionToJson(q));
        }

        return questionListJSON;
    }

    private static JSONArray noteListToJson(Forum f) {
        JSONArray noteListJSON = new JSONArray();
        List<Note> notes = f.getNotes();

        //make a JSON array
        for (Note n : notes) {
            noteListJSON.put(noteToJson(n));
        }

        return noteListJSON;
    }

    //main Jsonifier function()
    public static JSONObject forumToJson(Forum f) {
        JSONObject forumJSON = new JSONObject();

        //make a forum JSON object
        forumJSON.put("title", f.getTitle());
        forumJSON.put("questions", questionListToJson(f));
        forumJSON.put("notes", noteListToJson(f));
        forumJSON.put("Description", f.getDescription());

        return forumJSON;
    }

    public static void main(String[] args) {

        User poster = new User("Andrew", 0);
        User replier = new User("Tommy", 0);

        Question question1 = new Question(poster, "Testing Question 1", "Testing Title 1", "Testing Header 1");
        Answer answer1 = new Answer(replier, "Testing Answer 1");
        FollowUp followUp1 = new FollowUp(poster, "Testing FollowUp 1");
        question1.addAnswer(answer1);
        question1.addFollowUp(followUp1);

        Question question2 = new Question(poster, "Testing Question 2", "Testing Title 2", "Testing Header 2");
        question2.addAnswer(answer1);
        question2.addFollowUp(followUp1);

        Note note1 = new Note(poster, "Testing Note 1", "Testing Title 1", "Testing Header 1");
        note1.addFollowUp(followUp1);

        Note note2 = new Note(poster, "Testing Note 2", "Testing Title 2", "Testing Header 2");
        note1.addFollowUp(followUp1);

        Forum forum = new Forum("Test", "Testing Forum");

        forum.addQuestion(question1);
        forum.addQuestion(question2);
        forum.addNote(note1);
        forum.addNote((note2));

        JSONObject jsonObject = forumToJson(forum);

        System.out.println(jsonObject);

    }

}
