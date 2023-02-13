package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaylistListTest {
    private PlaylistList lib1;
    private PlaylistList lib2;
    private Playlist playlist1;
    private Playlist playlist2;
    private Playlist playlist3;

    @BeforeEach
    public void setup() {
        this.lib1 = new PlaylistList();
        this.lib2 = new PlaylistList();
        this.playlist1 = new Playlist("Pop");
        this.playlist2 = new Playlist("Rock and Roll");
        this.playlist3 = new Playlist("Workout");
    }

    @Test
    public void addToPlaylistTest() {
        this.lib1.addToPlaylists(playlist1);
        this.lib1.addToPlaylists(playlist3);
        assertEquals(lib1.getPlaylists().get(0), playlist1);
        assertEquals(lib1.getPlaylists().get(1), playlist3);
    }

    @Test
    public void findPlaylistTest() {
        lib1.addToPlaylists(playlist1);
        lib1.addToPlaylists(playlist2);
        lib1.addToPlaylists(playlist3);
        assertEquals(this.lib1.findPlaylist("Pop"), playlist1);
        assertEquals(this.lib1.findPlaylist("Rock and Roll"), playlist2);
        assertEquals(this.lib1.findPlaylist("Workout"), playlist3);
    }
}
