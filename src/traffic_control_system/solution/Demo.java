package traffic_control_system.solution;

public class Demo {
    public static void main(String[] args) {
        TrafficController trafficController = TrafficController.getInstance();

        Road road1 = new Road(1,"Main Street", new TrafficLight(1, 30000, 5000, 25000));
        Road road2 = new Road(2,"Cross Avenue", new TrafficLight(2, 35000, 5000, 20000));

        trafficController.addRoad(road1);
        trafficController.addRoad(road2);

        trafficController.startTrafficControl();

        // Simulate emergency handling after 10 seconds
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                trafficController.handleEmergency(1);
            }
        }, 10000);
    }
}
