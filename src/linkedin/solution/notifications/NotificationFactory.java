package linkedin.solution.notifications;

import linkedin.solution.User;

import java.sql.Timestamp;
import java.util.UUID;

public class NotificationFactory {

    public static Notification createNotification(User user, String content, NotificationType type) {
        return new Notification(UUID.randomUUID().toString(),
                user,new Timestamp(System.currentTimeMillis()),content,type);
    }
}
