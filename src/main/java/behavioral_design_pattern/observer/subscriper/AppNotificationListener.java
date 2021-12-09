package behavioral_design_pattern.observer.subscriper;

import behavioral_design_pattern.observer.FacebookUser;
import behavioral_design_pattern.observer.publisher.IEventListener;

public class AppNotificationListener implements IEventListener {

    private final FacebookUser user;

    public AppNotificationListener(FacebookUser user) {
        this.user = user;
    }

    @Override
    public void update(String eventType, String displayName, String url) {
        System.out.println(
                "App Notification >> Hey " + this.user.getFirstName() + ", " +
                        displayName + " posted new content: " + eventType + " >> " + url);
    }
}
