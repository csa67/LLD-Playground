package linkedin.solution;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<User> connections;
    private List<Connection> connectionRequests;
    private List<Message> inbox;
    private List<Message> sent;
    private Profile profile;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.connections = new ArrayList<>();
        this.connectionRequests = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.sent = new ArrayList<>();
        this.profile = new Profile();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<User> getConnections() {
        return connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void addToInbox(Message msg){
        inbox.add(msg);
    }

    public void addToSent(Message msg){
        sent.add(msg);
    }

    public List<Message> getSent() {
        return sent;
    }

    public List<Connection> getConnectionRequests() {
        return connectionRequests;
    }
}
