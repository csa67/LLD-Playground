package publisher_subscriber_system.solution;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Topic {
    private final int id;
    private final String name;
    private final Set<Subscriber> subscriberList = new CopyOnWriteArraySet<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Topic(String name) {
        this.id = generateId();
        this.name = name;
    }

    private int generateId() {
        return (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void publish(Message message) {
        for (Subscriber subscriber : subscriberList) {
            executor.submit(() -> subscriber.onMessage(message));
        }
    }
}
