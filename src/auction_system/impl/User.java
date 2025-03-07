package auction_system.impl;

public class User{
    private final String id;
    private final String name;
    private final String email;
    private final String password;


    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}