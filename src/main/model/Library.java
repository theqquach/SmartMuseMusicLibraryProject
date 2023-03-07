package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a list of playlists.
public class Library implements Writable {

    private String name;
    private ArrayList<Playlist> playlists;

    // EFFECTS: creates a new list of playlists with given name.
    public Library(String libName) {
        name = libName;
        playlists = new ArrayList<Playlist>();
    }

    // REQUIRES: no duplicate playlist name
    // EFFECTS: finds a playlist with given name in playlists, if none found, return null.
    public Playlist findPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(playlistName)) {
                return playlist;
            }
        }
        return null;
    }

    @Override
    // EFFECTS: returns Library as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("playlists", playlistsToJson());
        return json;
    }

    // EFFECTS: returns Playlists in Library as a JSON array
    public JSONArray playlistsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Playlist playlist : playlists) {
            jsonArray.put(playlist.toJson());
        }

        return jsonArray;
    }

    // MODIFIES: this
    // EFFECTS: adds given playlist to playlist list.
    public void addToPlaylists(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public String getName() {
        return name;
    }



}
