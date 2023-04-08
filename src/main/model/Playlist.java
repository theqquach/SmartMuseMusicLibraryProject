package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a playlist with name, length (# of songs), playtime (length of playlist in seconds), list of all songs
public class Playlist implements Writable {

    private final String name;  // name of playlist
    private int length;   // number of songs in playlist
    private int playtime; // total playtime of all songs in the playlist
    private final ArrayList<Song> songList; // list of songs in the playlist

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
        EventLog.getInstance().logEvent(new Event("song added to playlist"));
    }

    // REQUIRES: song must be in playlist and playlist must not be empty
    // EFFECTS: adds a song to the playlist, increases playlist length, playtime by song length ands adds song to List.
    public void removeSong(Song song) {
        if (songList.contains(song)) {
            this.length--;
            this.playtime = this.playtime - song.getLength();
            songList.remove(song);
            EventLog.getInstance().logEvent(new Event("song removed from playlist"));
        }
    }

    // REQUIRES: no duplicate song name
    // EFFECTS: finds a song with given name in playlist, if none found, return none found.
    public Song findSong(String songName) {
        Song selected = null;
        for (int i = 0; i < this.getLength(); i++) {
            if (this.songList.get(i).getName().equals(songName)) {
                selected = this.getSongList().get(i);
            }
        }
        EventLog.getInstance().logEvent(new Event("song found in given playlist"));
        return selected;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    public int getPlaytime() {
        return this.playtime;
    }

    public ArrayList<Song> getSongList() {
        return this.songList;
    }

    @Override
    //EFFECTS: converts playlist into a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("length", Integer.toString(length));
        json.put("playtime", Integer.toString(playtime));
        json.put("songList", songListToJson());
        return json;
    }

    // EFFECTS: returns Songs in Playlist as a JSON array
    public JSONArray songListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Song song : songList) {
            jsonArray.put(song.toJson());
        }

        return jsonArray;
    }
}
