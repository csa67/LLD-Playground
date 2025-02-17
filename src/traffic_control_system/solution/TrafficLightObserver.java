package traffic_control_system.solution;

import traffic_control_system.solution.state.Signal;

public interface TrafficLightObserver {
    void onSignalChange(int id, Signal newSignal);
}
