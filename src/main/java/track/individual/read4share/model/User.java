package track.individual.read4share.model;

import lombok.Getter;

@Getter
public class User {

    private String username;
    private String email;
    private City city;

    public User() {

    }

    public User(String username, String email, City city) {
        this.username = username;
        this.email = email;
        this.city = city;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
