package publisher_subscriber_system.solution;

public class Demo {
    public static void main(String[] args) {
        PubSubSystem pubSubSystem = PubSubSystem.getPubSubSystem();

        //Create and register topics
        Topic topic1 = new Topic(1,"Sports");
        Topic topic2 = new Topic(2,"News");

        pubSubSystem.registerTopic(topic1);
        pubSubSystem.registerTopic(topic2);

        //Create publishers
        Publisher publisher1 = new Publisher("CNN");
        Publisher publisher2 = new Publisher("ESPN");

        pubSubSystem.addPublisher(publisher1);
        pubSubSystem.addPublisher(publisher2);

        // Create Subscribers
        Subscriber alice = new PrintSubscriber("Alice");
        Subscriber bob = new PrintSubscriber("Bob");

        //Subscribe users to topics
        pubSubSystem.subscribe(topic1, alice);
        pubSubSystem.subscribe(topic2, bob);
        pubSubSystem.subscribe(topic2, alice);

        //Publish messages
        pubSubSystem.publish(topic1.getId(),publisher1,new Message("Breaking: Elections coming up!"));
        pubSubSystem.publish(topic2.getId(), publisher2,  new Message("Match result: Team A wins!"));
    }
}
