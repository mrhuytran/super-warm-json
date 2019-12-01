import com.mrhuytran.forums.Forum;
import com.mrhuytran.threads.Note;
import com.mrhuytran.threads.Question;
import com.mrhuytran.users.User;


public class Main {

    public static void main(String[]  args) {
        User poster = new User("Andrew", 0);

        Question question = new Question(poster, "Testing Question", "Testing Title", "Testing Header");
        Note note = new Note(poster, "Testing Note", "Testing Title", "Testing Header");

        Forum forum = new Forum("Test", "Testing Forum");

        forum.addQuestion(question);
        forum.addNote(note);

    }

}
