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
    
}
