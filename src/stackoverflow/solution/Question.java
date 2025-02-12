package stackoverflow.solution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable{
    private int id;
    private String title;
    private String content;
    private List<Vote> votes;
    private User author;
    private Date date;
    private List<Answer> answers;
    private List<Tag> tags;
    private List<Comment> comments;

    Question(String title, String content, User author, List<String> tagNames) {
        this.id= generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = new Date();
        this.answers = new ArrayList<Answer>();
        this.votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        for(String tagName : tagNames) {
            this.tags.add(new Tag(tagName));
        }
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addAnswer(Answer answer) {
        if(!answers.contains(answer)) {
            answers.add(answer);
        }
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void vote(User user, int value) {
        if(value!=-1 && value!=1){
            throw new IllegalArgumentException("You cannot vote more than 1 vote");
        }
        votes.removeIf(vote -> vote.getUser().equals(user));
        Vote vote = new Vote(user, value);
        votes.add(vote);
        author.updateRating(value*5);
    }

    @Override
    public int getValueCount() {
        return votes.stream().mapToInt(Vote::getTotalVotes).sum();
    }

    public Integer getId() {
        return id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
