package traffic_control_system.solution;

import traffic_control_system.solution.state.Signal;

public class Road implements TrafficLightObserver{
    private int id;
    private final String name;
    private final TrafficLight trafficLight;

    public Road(Integer id, String name, TrafficLight trafficLight) {
        this.id = id;
        this.name = name;
        this.trafficLight = trafficLight;
    }

    @Override
    public void onSignalChange(int id, Signal newSignal) {
        System.out.println("🚗 Road " + name + " notified: Traffic Light " + id + " changed to " + newSignal);
    }

    public int getId() {
        return id;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
}
