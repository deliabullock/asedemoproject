package hello;

import org.springframework.data.annotation.Id;

public class Image {

    @Id
    public String id;

    public String username;
    public String image; //image data stored as string

    public Image() {}

    public Image(String username, String image) {
        this.username = username;
        this.image = image;
    }

    public String getId() {
	return this.id;
    }

    public String getUsername() {
	return this.username;
    }

    public String getImage() {
	return this.image;
    }

}
