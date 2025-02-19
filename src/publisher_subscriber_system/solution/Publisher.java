package publisher_subscriber_system.solution;

public class Publisher {
    private final String name;

    public Publisher(String name) {
        this.name = name;
        PubSubSystem.getPubSubSystem().addPublisher(this);
    }

    public String getName() {
        return name;
    }
}
