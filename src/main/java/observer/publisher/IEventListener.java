package observer.publisher;

public interface IEventListener {
    void update(String eventType, String displayName, String url);
}
