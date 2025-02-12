package stackoverflow.solution;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable,Votable {
    private int id;
    private Question question;
    private String text;
    private User author;
    private Date date;
    private List<Comment> comments;
    private List<Vote> votes;
    private boolean isAccepted;

    public Answer(Question qestion,User author,String content) {
        this.author = author;
        this.text = content;
        this.question = question;
        this.id = generateId();
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
        this.votes = new ArrayList<Vote>();
        this.isAccepted = false;
    }

    private int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }


    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if(value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user,value));
        author.updateRating(value*10);
    }

    @Override
    public int getValueCount() {
        return votes.stream().mapToInt(Vote::getTotalVotes).sum();
    }

    public void markAsAccepted() {
        if(isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateRating(50);
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Question getQuestion() {
        return question;
    }
}
