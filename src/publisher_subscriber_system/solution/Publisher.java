package publisher_subscriber_system.solution;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Publisher {
    private final ConcurrentHashMap<Integer, Topic> topics;

    public Publisher() {
        topics = new ConcurrentHashMap<>();
    }

    public void registerTopic(Topic topic){
        topics.put(topic.getId(),topic);
    }

    public void publish(Integer topicId,Message message){
        Topic topic = topics.get(topicId);
        if(!topics.contains(topic)){
            System.out.println("This topic not found: " + topicId);
            return;
        }
        topic.publish(message);
    }
}
