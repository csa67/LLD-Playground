package linkedin.solution.notifications;

import linkedin.solution.User;

import java.sql.Timestamp;

public class Notification {
    private final String id;
    private final User user;
    private final Timestamp timestamp;
    private final String content;
    private final NotificationType type;

    public Notification(String id, User user, Timestamp timestamp, String content, NotificationType type) {
        this.id = id;
        this.user = user;
        this.timestamp = timestamp;
        this.content = content;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}
