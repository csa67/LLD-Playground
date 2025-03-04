package linkedin.solution.notifications;

public interface Observer {
    void update(String userId, Notification notification);
}
