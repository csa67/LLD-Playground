package traffic_control_system.solution.state;

import traffic_control_system.solution.TrafficLight;

public class RedState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("🚦 Traffic Light " + trafficLight.getId() + " is RED. Vehicles must stop.");
        try{
            Thread.sleep(trafficLight.getRedDuration());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trafficLight.setState(new GreenState()); // Next state is GREEN
    }

    @Override
    public Signal getSignal() {
        return Signal.RED;
    }
}
