package linkedin.solution.notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationService implements Observer {

    private final ConcurrentHashMap<String, List<Notification>> userNotifications = new ConcurrentHashMap<>();
    @Override
    public void update(String userId, Notification notification) {
        userNotifications.computeIfAbsent(userId, k -> new ArrayList<>()).add(notification);
        System.out.println(notification.getContent());
    }

    public List<Notification> getUserNotifications(String userId) {
        return userNotifications.get(userId);
    }
}
