package hello;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String username;
    public String hash;

    public User() {}

    public User(String username, String hash) {
        this.username = username;
        this.hash = hash;
    }

    public String getId() {
	return this.id;
    }

    public String getUsername() {
	return this.username;
    }

    public String getHash() {
	return this.hash;
    }

}
