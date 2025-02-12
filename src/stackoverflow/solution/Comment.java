package stackoverflow.solution;

import java.util.Date;

public class Comment {
    private final int id;
    private final String comment;
    private final User author;
    private final Date creationDate;

    public Comment(String comment, User author ) {
        this.id = generateId();
        this.comment = comment;
        this.author = author;
        this.creationDate = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
