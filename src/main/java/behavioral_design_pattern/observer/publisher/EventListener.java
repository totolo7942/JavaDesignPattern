package behavioral_design_pattern.observer.publisher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EventListener {

    private Map<String, List<IEventListener>> events;

    public EventListener(String ... eventType) {
        this.events = new LinkedHashMap<>();
        for(String type : eventType) {
            events.put(type, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, IEventListener iEventListener) {
        List<IEventListener> event = this.events.get(eventType);
        event.add(iEventListener);
    }

    public void unsubscribe(String eventType, IEventListener listener) {
        List<IEventListener> users =  this.events.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, String displayName, String url) {
        List<IEventListener> users =  this.events.get(eventType);
        for (IEventListener listener : users) {
            listener.update(eventType, displayName, url);
        }
    }

}
