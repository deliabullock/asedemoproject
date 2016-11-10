package hello;

import org.springframework.data.annotation.Id;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {

    @Id
    public String id;

    public String username;
    public String password;
//    StandardPasswordEncoder encoder = new StandardPasswordEncoder("secret");

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
	return this.id;
    }

    public String getUsername() {
	return this.username;
    }

    public boolean match(String p) {
//	return (this.password == encoder.encode(p));
	return this.password.equals(p);
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, username='%s', password='%s']",
                id, username, password);
    }

}
