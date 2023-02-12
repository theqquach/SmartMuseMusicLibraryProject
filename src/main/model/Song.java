package model;

// Represents a song with a name, artist, length (in seconds), favourited status
public class Song {

    private String name;      // song name
    private String artist;    // song artist
    private int length;       // song length
    private String status;    // favourited status "favourited", "disliked" or "none"

    // REQUIRES: songLength >= 0
    // EFFECTS: sets songName as song, artistName as artist and length as songLength. Sets status as "none" by default.
    public Song(String songName, String artistName, int songLength) {
        name = songName;
        artist = artistName;
        length = songLength;
        status = "none";
    }

    // EFFECTS: sets status to "favourited"
    public void favouriteSong() {
        this.status = "favourited";
    }

    // EFFECTS: sets status to "disliked"
    public void dislikeSong() {
        this.status = "disliked";
    }

    // EFFECTS: resets status to "none"
    public void resetStatus() {
        this.status = "none";
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }

    public String getStatus() {
        return status;
    }

}