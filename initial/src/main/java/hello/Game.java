package com.therealzads.telestrations.controller;

public class Game {
    private int gameID;
    private String gameName;
    private int creatorID; //user ID of game creator
    private int length; //predetermined length of game
    private int currLength; //current length of the game

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
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

    public void setCurrLength(int currLength) {
        this.currLength = currLength;
    }
    
}
