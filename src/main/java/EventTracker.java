import java.util.HashMap;
import java.util.Map;

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();
    private Map<String, Integer> tracker = new HashMap<>();


    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        return null;
    }

    synchronized public void push(String message) {
        if(tracker.containsKey(message)){
            Integer i = tracker.get(message);
            tracker.put(message,i++);
        }
        tracker.put(message, 1);
    }

    synchronized public Boolean has(String message) {
        return tracker.containsKey(message) && tracker.get(message) > 0 ? true:false;
    }

    synchronized public void handle(String message, EventHandler e) {
        Integer i = tracker.get(message);
        tracker.put(message,i-1);
    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }

    public HashMap<String, Integer> getTracker() {
        return (HashMap<String, Integer>) tracker;
    }
}
