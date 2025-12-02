package com.littlesekii.playground.examples.annotations;

@StreamerData
public class Streamer {
    private String name;    
    private String mostPlayedGame;

    public Streamer() {}

    public Streamer(String name, String mostPlayedGame) {
        this.name = name;
        this.mostPlayedGame = mostPlayedGame;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMostPlayedGame() {
        return mostPlayedGame;
    }
    public void setMostPlayedGame(String mostPlayedGame) {
        this.mostPlayedGame = mostPlayedGame;
    }
}
