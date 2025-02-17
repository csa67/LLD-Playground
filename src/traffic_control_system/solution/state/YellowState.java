package traffic_control_system.solution.state;

import traffic_control_system.solution.TrafficLight;

public class YellowState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("🚦 Traffic Light " + trafficLight.getId() + " is YELLOW. Vehicles should prepare to stop!");
        try{
            Thread.sleep(trafficLight.getYellowDuration());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trafficLight.setState(new RedState()); // Next state is GREEN
    }

    @Override
    public Signal getSignal() {
        return Signal.YELLOW;
    }
}
