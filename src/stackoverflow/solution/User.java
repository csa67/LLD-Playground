package stackoverflow.solution;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private int rating;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
        this.rating = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags){
        Question question = new Question(title, content, this, tags);
        this.questions.add(question);
        updateRating(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(String content, Question question){
        Answer answer = new Answer(question,this, content);
        this.answers.add(answer);
        question.addAnswer(answer);
        updateRating(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(String content, Commentable commentable){
        Comment comment = new Comment(content,this);
        this.comments.add(comment);
        commentable.addComment(comment);
        updateRating(COMMENT_REPUTATION);
        return comment;
    }

    public void updateRating(int i) {
        this.rating += i;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
