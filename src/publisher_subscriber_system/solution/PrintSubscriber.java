package publisher_subscriber_system.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintSubscriber implements Subscriber {
    private final String name;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(Message message) {
        executor.submit(() ->
            System.out.println("Subscriber "+name+" received message: "+ message.getContent())
        );
    }
}
