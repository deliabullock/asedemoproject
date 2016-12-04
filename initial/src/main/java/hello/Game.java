package hello;

import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

public class Game {
    @Id
    public String id;

    private String name;
    private String phrase;
    private String creator; //user ID of game creator
    private int length; //predetermined length of game
    private int currLength; //current length of the game
    private List<String> players; // game players, contains creator
    private ArrayList<String[]> ImagePhrasePairs = new ArrayList<String[]>();

    
    public Game() {
    	
    }
    
    public Game(String _name, String _phrase, String _creator, int _length, int _currLength) {
    	this.name = _name;
    	this.phrase = _phrase;
    	this.creator = _creator;
    	this.length = _length;
    	this.currLength = _currLength;
		this.players = new ArrayList<String>();
		this.players.add(this.creator);
		String [] phraseId = new String[2];
		phraseId[0] = "000";
		phraseId[1] = "000";
		this.ImagePhrasePairs.add(phraseId);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String gameName) {
        this.name = gameName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCurrLength() {
        return currLength;
    }

    public void addPlayer(String creatorId){
		this.players.add(creatorId);
    } 

    public List<String> getPlayers(){
		return this.players;
    } 

    public void setCurrLength(int currLength) {
        this.currLength = currLength;
    }

    public String getLastPhrase() {
        String [] phraseId = ImagePhrasePairs.get(ImagePhrasePairs.size()-1);
		return phraseId[1];
    }    

    public String getLastImage() {
        String [] imageId = ImagePhrasePairs.get(ImagePhrasePairs.size()-1);
		return imageId[0];
    }
    
    public void addImage(String id) {
		if (currLength < length) {
			currLength = currLength + 1;
			String [] phraseId = new String[2];
			phraseId[0] = id;
			ImagePhrasePairs.add(phraseId);
		}
    }
  
    public void addPhrase(String id) {
		if (currLength < length) {
			currLength = currLength + 1;
			String [] imageId = ImagePhrasePairs.remove(ImagePhrasePairs.size()-1);
			imageId[1] = id;
			ImagePhrasePairs.add(imageId);
		}
    }  
}    
