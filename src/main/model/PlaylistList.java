package model;

import java.util.ArrayList;

public class PlaylistList {

    private ArrayList<Playlist> playlists;

    public PlaylistList() {
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

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    // MODIFIES: this
    // EFFECTS: adds given playlist to playlist list.
    public void addToPlaylists(Playlist playlist) {
        this.playlists.add(playlist);
    }



}
