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

    public Topic(Integer id,String name) {
        this.id = id;
        this.name = name;
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
