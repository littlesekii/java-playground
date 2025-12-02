package com.littlesekii.playground.examples.annotations;

public class ExampleMain {

    public static void main(String[] args) {
    
        if (Streamer.class.isAnnotationPresent(StreamerData.class)) {
            StreamerData data = Streamer.class.getAnnotation(StreamerData.class);

            System.out.println("Streamer is " + data.name());
            System.out.println("Most played game: " + data.mostPlayedGame()); 
        }
    }


}
