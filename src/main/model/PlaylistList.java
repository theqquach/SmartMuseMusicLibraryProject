package model;

import java.util.ArrayList;

public class PlaylistList extends ArrayList {

    private ArrayList<Playlist> playlists;

    public PlaylistList() {
        playlists = new ArrayList<Playlist>();
    }

    // REQUIRES: no duplicate playlist name
    // EFFECTS: finds a playlist with given name in playlists, if none found, return none found.
    public Playlist findPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName() == playlistName) {
                return playlist;
            }
        }
        return null;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }



}
