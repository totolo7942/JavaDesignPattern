package observer.subscriper;

import observer.FacebookUser;
import observer.publisher.IEventListener;

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
