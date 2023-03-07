package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LibraryTest {
    private Library lib1;
    private Library lib2;
    private Playlist playlist1;
    private Playlist playlist2;
    private Playlist playlist3;

    @BeforeEach
    public void setup() {
        this.lib1 = new Library("Alex's Library");
        this.lib2 = new Library("Mumma's Library");
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
        assertEquals(lib1.getName(), "Alex's Library");
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

    @Test
    public void findPlaylistNullTest() {
        lib1.addToPlaylists(playlist1);
        lib1.addToPlaylists(playlist2);
        lib1.addToPlaylists(playlist3);
        assertNull(this.lib1.findPlaylist("Dancing"));
    }

    @Test
    public void emptyLibraryToJsonTest() {
        String json = lib1.toJson().toString();
        assertEquals("{\"name\":\"Alex's Library\",\"playlists\":[]}", json);
    }

    @Test
    public void emptyPlaylistsToJsonTest() {
        lib1.addToPlaylists(playlist1);
        String json = lib1.toJson().toString();
        assertEquals("{\"name\":\"Alex's Library\",\"playlists\":[{\"name\":\"Pop\",\"length\":\"0\",\"playtime\":\"0\",\"songList\":[]}]}", json);
    }
}
