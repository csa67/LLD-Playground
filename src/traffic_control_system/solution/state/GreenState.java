package traffic_control_system.solution.state;

import traffic_control_system.solution.TrafficLight;

public class GreenState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("🚦 Traffic Light " + trafficLight.getId() + " is GREEN. Vehicles can go!");
        try{
            Thread.sleep(trafficLight.getGreenDuration());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trafficLight.setState(new YellowState()); // Next state is GREEN
    }

    @Override
    public Signal getSignal() {
        return Signal.GREEN;
    }
}
