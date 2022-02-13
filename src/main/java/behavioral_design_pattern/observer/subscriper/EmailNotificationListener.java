package behavioral_design_pattern.observer.subscriper;

import behavioral_design_pattern.observer.FacebookUser;
import behavioral_design_pattern.observer.publisher.IEventListener;

public class EmailNotificationListener implements IEventListener {

    private final FacebookUser user;

    public EmailNotificationListener(FacebookUser user) {
        this.user = user;
    }

    @Override
    public void update(String eventType, String displayName, String url) {
        System.out.println(
                "Email Notification >> Hey " + this.user.getFirstName() + ", " +
                        displayName + " posted new content: " + eventType + " >> " + url);
    }
}
