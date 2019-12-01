package com.mrhuytran.json;

import com.mrhuytran.forums.Forum;
import com.mrhuytran.threads.Note;
import com.mrhuytran.threads.Post;
import com.mrhuytran.threads.Question;
import com.mrhuytran.threads.Thread;
import com.mrhuytran.users.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ForumParser {

    private User parseUserJson(JSONObject threadJson) {
        if (threadJson.get("poster") instanceof  String) {
            return new User(threadJson.getString("poster"), threadJson.getInt("poster-points"));
        } else {
            throw new JSONException("Invalid data type.");
        }
    }

    //helper function for parseDatePosted()
    private void checkClassDatePostedJsonValues(JSONObject datePostedJson) {
        if (!(datePostedJson.get("year") instanceof Integer)
                || !(datePostedJson.get("month") instanceof Integer)
                || !(datePostedJson.get("day") instanceof Integer)
                || !(datePostedJson.get("hour") instanceof Integer)
                || !(datePostedJson.get("minute") instanceof Integer)) {
            throw new JSONException("Invalid data type.");
        }
    }

    private GregorianCalendar parseDatePostedJson(JSONObject datePostedJson) {
        checkClassDatePostedJsonValues(datePostedJson);
        int year = datePostedJson.getInt("year");
        int month = datePostedJson.getInt("month");
        int day = datePostedJson.getInt("day");
        int hour = datePostedJson.getInt("hour");
        int min = datePostedJson.getInt("minute");
        GregorianCalendar datePosted = new GregorianCalendar(year, month, day, hour, min);
        return datePosted;
    }

    private Thread parseThreadJson(JSONObject threadJSON) {
        User poster = parseUserJson(threadJSON);
        GregorianCalendar datePosted = parseDatePostedJson(threadJSON.getJSONObject("date-posted"));
        if (!(threadJSON.get("body") instanceof String)) {
            throw new JSONException("Invalid data type.");
        }
        String body =  threadJSON.getString("body");
        Thread t = new Thread(poster, body, datePosted);

        return t;
    }

    private ArrayList<Thread> parseThreadListJson(JSONArray threadListJSON) {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (Object o : threadListJSON) {
            JSONObject threadJSON = (JSONObject) o;
            threads.add(parseThreadJson(threadJSON));
        }

        return threads;
    }

    private String parseTagJson(JSONObject tagJSON) {
        if (tagJSON.get("tag") instanceof String) {
            return tagJSON.getString("tag");
        } else {
            throw new JSONException("Invalid data type.");
        }
    }

    private ArrayList<String> parseTagListJson(JSONArray tagListJSON) {
        ArrayList<String> tags = new ArrayList<String>();
        for (Object o : tagListJSON) {
            JSONObject tagJSON = (JSONObject) o;
            tags.add(parseTagJson(tagJSON));
        }

        return tags;
    }

    private Post parsePostJson(JSONObject postJSON) {
        Thread t = parseThreadJson(JSONObject postJSON);
        String title = "";
        if (postJSON.get("title") instanceof String) {
            title = postJSON.getString("title");
        } else {
            throw new JSONException("Invalid data type.");
        }
        String header = "";
        if (postJSON.get("header") instanceof String) {
            header = postJSON.getString("header");
        } else {
            throw new JSONException("Invalid data type.");
        }
        ArrayList<String> tags = parseTagListJson(postJSON.getJSONArray("tags"));
        int views = postJSON.getInt("views");
        ArrayList<Thread> followUps = parseThreadListJson(postJSON.getJSONArray("follow-ups"));

        Post post = new Post(t.getPoster(), t.getBody(), title, header, tags, views, followUps);

        return post;
    }

    private Question parseQuestionJson(JSONObject questionJSON) {
        Post p = parsePostJson(questionJSON.getJSONObject("question"));
        ArrayList<Thread> answers = parseThreadListJson(questionJSON.getJSONArray("answers"));

        Question q = new Question(p.getPoster(), p.getBody(), p.getTitle(), p.getHeader(),
                p.getTags(), p.getViews(), p.getFollowUps(), answers);

        return q;
    }

    private ArrayList<Question> parseQuestionListJson(JSONArray questionListJSON) {
        ArrayList<Question> questions = new ArrayList<Question>();
        for (Object o : questionListJSON) {
            JSONObject questionJSON = (JSONObject) o;
            questions.add(parseQuestionJson(questionJSON));
        }

        return questions;
    }

    private Note parseNoteJson(JSONObject noteJSON) {
        Post p = parsePostJson(noteJSON.getJSONObject("note"));

        Note n = new Note(p.getPoster(), p.getBody(), p.getTitle(),
                p.getHeader(), p.getTags(), p.getViews(), p.getFollowUps());

        return n;
    }

    private ArrayList<Note> parseNoteListJson(JSONArray noteListJSON) {
        ArrayList<Note> notes = new ArrayList<Note>();
        for (Object o : noteListJSON) {
            JSONObject noteJSON = (JSONObject) o;
            notes.add(parseNoteJson(noteJSON));
        }

        return notes;
    }

    public Forum parseForumJson(JSONObject forumJSON) {
        String title = "";
        if (forumJSON.get("title") instanceof String) {
            title = forumJSON.getString("title");
        } else {
            throw new JSONException("Invalid data type.");
        }
        ArrayList<Question> questions = parseQuestionListJson(forumJSON.getJSONArray("questions"));
        ArrayList<Note> notes = parseNoteListJson((forumJSON.getJSONArray("notes")));
        String description = "";
        if (forumJSON.get("description") instanceof String) {
            description = forumJSON.getString("description");
        } else {
            throw new JSONException("Invalid data type.");
        }

        Forum f = new Forum(title, description, questions, notes);

        return f;
    }
}
