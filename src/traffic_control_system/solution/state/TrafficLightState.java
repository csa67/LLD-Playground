package traffic_control_system.solution.state;

import traffic_control_system.solution.TrafficLight;

public interface TrafficLightState {
    void handle(TrafficLight trafficLight);
    Signal getSignal();
}
