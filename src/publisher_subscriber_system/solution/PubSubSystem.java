package publisher_subscriber_system.solution;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class PubSubSystem {
    private static PubSubSystem pubSubSystem;

    private final Map<Integer,Topic> topics = new ConcurrentHashMap<>();
    private final Set<Publisher> publishers = new CopyOnWriteArraySet<>();

    public static PubSubSystem getPubSubSystem() {
        if(pubSubSystem == null){
            pubSubSystem = new PubSubSystem();
        }
        return pubSubSystem;
    }

    public void registerTopic(Topic topic){
        topics.put(topic.getId(), topic);
    }

    public void addPublisher(Publisher publisher){
        publishers.add(publisher);
    }

    public void removePublisher(Publisher publisher){
        publishers.remove(publisher);
    }

    public void subscribe(Topic topic, Subscriber subscriber){
        Topic t = topics.get(topic.getId());
        if(t != null){
            t.addSubscriber(subscriber);
        }else{
            System.err.println("topic not found" + topic.getId());
        }
    }

    public void publish(Integer topicId, Publisher publisher, Message message){
        if(!publishers.contains(publisher)){
            System.out.println("Publisher " + publisher.getName() + " not registered");
            return;
        }

        Topic topic = topics.get(topicId);
        if(topic == null){
            System.out.println("Topic " + topicId + " not found");
            return;
        }

        topic.publish(message);
    }
}
