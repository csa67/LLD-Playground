package linkedin.solution;

import java.sql.Timestamp;

public class Message {

    private final String id;
    private User sender;
    private User recipient;
    private String content;
    private Timestamp timestamp;

    public Message(String id, User sender, User recipient, String message, Timestamp timestamp) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = message;
        this.timestamp = timestamp;
    }
}
