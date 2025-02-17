package traffic_control_system.solution;

import traffic_control_system.solution.state.RedState;
import traffic_control_system.solution.state.Signal;
import traffic_control_system.solution.state.TrafficLightState;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {
    private int id;
    private TrafficLightState state;
    private List<TrafficLightObserver> observers = new ArrayList<>();
    private final int redDuration;
    private final int yellowDuration;
    private final int greenDuration;

    public TrafficLight(int id, int redDuration, int yellowDuration, int greenDuration) {
        this.id = id;
        this.state = new RedState();
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
    }

    void handle(){
        state.handle(this);
    }

    public void setState(TrafficLightState state) {
        this.state = state;
        notifyObservers(state.getSignal());
    }

    public int getId() {
        return id;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void addObserver(TrafficLightObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TrafficLightObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Signal signal) {
        for (TrafficLightObserver observer : observers) {
            observer.onSignalChange(id, signal);
        }
    }
}
