package hello;

import org.springframework.data.annotation.Id;

public class Password {

    @Id
    public String id;

    public String hash;
    public String token;

    public Password() {}

    public Password(String hash, String token) {
        this.hash = hash;
        this.token = token;
    }

    public String getId() {
	return this.id;
    }

    public String getToken() {
	return this.token;
    }

}
