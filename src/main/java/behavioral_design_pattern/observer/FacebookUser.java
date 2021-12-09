package behavioral_design_pattern.observer;


public class FacebookUser {
    private String firstName;
    private String email;

    public FacebookUser(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}
