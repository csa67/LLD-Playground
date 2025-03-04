package linkedin.solution;

import linkedin.solution.notifications.Notification;
import linkedin.solution.notifications.NotificationFactory;
import linkedin.solution.notifications.NotificationType;
import linkedin.solution.notifications.Observer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedinService {
    private static LinkedinService instance;
    private Map<String, User> users;
    private final Map<String, JobPosting> jobPostings;
    private final List<Observer> observers = new ArrayList<>();

    private LinkedinService() {
        users = new ConcurrentHashMap<>();
        jobPostings = new ConcurrentHashMap<>();
    }

    public synchronized static LinkedinService getInstance() {
        if(instance == null) {
            instance = new LinkedinService();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String userId, Notification notification) {
        for(Observer observer : observers) {
            observer.update(userId, notification);
        }
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User login(String email, String password) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Invalid email or password");
    }

    public void updateUserProfile(String userId, Profile profile) {
        User user = users.get(userId);
        if(user.getProfile() != profile){
            user.setProfile(profile);
            System.out.println("Profile updated successfully!");
        }
    }

    public void sendConnectionRequest(User sender, User receiver) {
        Connection connection = new Connection(sender,new Timestamp(System.currentTimeMillis()));
        receiver.getConnectionRequests().add(connection);
        Notification notification = NotificationFactory.createNotification(
                receiver,
                "New connection request from "+sender.getName(),
                NotificationType.CONNECTION_REQUEST);
        notifyObservers(receiver.getId(), notification);
    }

    public void acceptConnectionRequest(User sender, User receiver) {
        for(Connection connection : receiver.getConnectionRequests()) {
            if(connection.getUser().getId().equals(sender.getId())) {
                receiver.getConnections().add(sender);
                System.out.println("Accepted connection request from "+sender.getName()+" to "+receiver.getName());
                receiver.getConnectionRequests().remove(connection);
                break;
            }
        }
    }

    public void postJobListing(JobPosting jobPosting) {
        jobPostings.put(jobPosting.getId(), jobPosting);
        for(User user : users.values()) {
            Notification notification = NotificationFactory.createNotification(
                    user,
                    "New job posting "+jobPosting.getTitle()+ " from "+jobPosting.getCompany(),
                    NotificationType.JOB_POSTING);

            notifyObservers(user.getId(), notification);
        }
    }

    public void sendMessage(User sender, User receiver, String message) {
        Message msg = new Message(generateMsgId(),sender,receiver,message,new Timestamp(System.currentTimeMillis()));
        receiver.addToInbox(msg);
        sender.addToSent(msg);
        Notification notification = NotificationFactory.createNotification(
                receiver,
                "New message from "+sender.getName(),
                NotificationType.MESSAGE);

        notifyObservers(receiver.getId(), notification);
    }

    public List<User> searchUsers(String query) {
        List<User> result = new ArrayList<>();
        for(User user: users.values() ) {
            if(user.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(user);
            }
        }
        return result;
    }

    public List<JobPosting> searchJobPostings(String query) {
        List<JobPosting> result = new ArrayList<>();
        for(JobPosting jobPosting: jobPostings.values()) {
            if(jobPosting.getTitle().toLowerCase().contains(query.toLowerCase())) {
                result.add(jobPosting);
            }
        }
        return result;

    }

    private String generateMsgId() {
        return UUID.randomUUID().toString();
    }
}
