package model;

import java.util.ArrayList;

// Represents a playlist with name, length (# of songs), playtime (length of playlist in seconds), list of all songs
public class Playlist {

    private String name;  // name of playlist
    private int length;   // number of songs in playlist
    private int playtime; // total playtime of all songs in the playlist
    private ArrayList<Song> songList; // list of songs in the playlist

    public Playlist(String playlistName) {
        name = playlistName;
        length = 0;
        playtime = 0;
        songList = new ArrayList<Song>();
    }

    // EFFECTS: adds a song to the playlist, increases playlist length, playtime by song length ands adds song to List.
    public void addSong(Song song) {
        this.length++;
        this.playtime = song.getLength() + this.playtime;
        songList.add(song);
    }

    // REQUIRES: song must be in playlist
    // EFFECTS: adds a song to the playlist, increases playlist length, playtime by song length ands adds song to List.
    public void removeSong(Song song) {
        if (songList.contains(song)) {
            this.length--;
            this.playtime = song.getLength() + this.playtime;
            songList.add(song);
        }
    }

}
