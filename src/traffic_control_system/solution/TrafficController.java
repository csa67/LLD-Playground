package traffic_control_system.solution;

import traffic_control_system.solution.state.GreenState;
import traffic_control_system.solution.state.RedState;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficController {
    private static TrafficController instance;
    private final Map<Integer,Road> roads;
    private final ScheduledExecutorService scheduler;

    private TrafficController() {
        roads = new HashMap<>();
        scheduler = Executors.newScheduledThreadPool(1);
    }

    public static synchronized TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        roads.put(road.getId(),road);
    }

    public void removeRoad(Integer roadId) {
        roads.remove(roadId);
    }

    void startTrafficControl(){
        scheduler.scheduleAtFixedRate(this::cycleTrafficLights,0,1, TimeUnit.SECONDS);
    }

    private void cycleTrafficLights() {
        for(Road road : roads.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.handle();
        }
    }

    public void handleEmergency(Integer roadId){
        Road emergencyRoad = roads.get(roadId);
        if(emergencyRoad != null) {
            for(Road road : roads.values()) {
                if(!road.equals(emergencyRoad)) {
                    road.getTrafficLight().setState(new RedState());
                }
            }

            emergencyRoad.getTrafficLight().setState(new GreenState());
            System.out.println("Emergency! Road " + roadId + " gets GREEN.");
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }

}
