package publisher_subscriber_system.solution;

public class Demo {
    public static void main(String[] args) {
        Topic topic1 = new Topic("topic1");
        Topic topic2 = new Topic("topic2");

        //Create publishers
        Publisher publisher = new Publisher();

        //Create subscribers
        Subscriber s1 = new PrintSubscriber("s1");
        Subscriber s2 = new PrintSubscriber("s2");
        Subscriber s3 = new PrintSubscriber("s3");

        publisher.registerTopic(topic1);
        publisher.registerTopic(topic2);

        //Subscribe to topics
        topic1.addSubscriber(s1);
        topic1.addSubscriber(s2);
        topic2.addSubscriber(s2);
        topic2.addSubscriber(s3);

        int topic1Id = topic1.getId();
        int topic2Id = topic2.getId();
        System.out.println("Topic 1: " + topic1Id);

        publisher.publish(topic1Id,new Message("Message 1 for Topic 1"));
        publisher.publish(topic2Id,new Message("Message 1 for Topic 2"));
        publisher.publish(topic1Id,new Message("Message 2 for Topic 1"));

        //Unsubscribe
        topic1.removeSubscriber(s1);

        publisher.publish(topic1Id, new Message("Message3 for Topic1"));
    }
}
