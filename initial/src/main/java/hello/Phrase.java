package hello;

import org.springframework.data.annotation.Id;

public class Phrase {

    @Id
    public String id;

    public String username;
    public String phrase;

    public Phrase() {}

    public Phrase(String username, String phrase) {
        this.username = username;
        this.phrase = phrase;
    }

    public String getId() {
	return this.id;
    }

    public String getUsername() {
	return this.username;
    }

    public String getPhrase() {
	return this.phrase;
    }

}
