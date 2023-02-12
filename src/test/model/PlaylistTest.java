package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    private Playlist playlist1;
    private Playlist playlist2;
    private Playlist playlist3;
    private Song song1;
    private Song song2;
    private Song song3;

    @BeforeEach
    public void setup() {
        this.playlist1 = new Playlist("Workout");
        this.playlist2 = new Playlist("Chill");
        this.playlist3 = new Playlist("Dance Practice");
        this.song1 = new Song("Red", "Taylor Swift", 223);
        this.song2 = new Song("OMG", "NewJeans", 212);
        this.song3 = new Song("what would you do?", "Tate McRae",165);

    }

    @Test
    public void addSongTest() {
    assertTrue(this.playlist1.getSongList().isEmpty());
    this.playlist1.addSong(song1);
    assertTrue(this.playlist1.getSongList().get(0) == song1);
    assertTrue(this.playlist1.getLength() == 1);
    assertTrue(this.playlist1.getPlaytime() == 223);
    }

    @Test
    public void addAnotherSongTest() {
        this.playlist1.addSong(song1);
        this.playlist1.addSong(song3);
        assertTrue(this.playlist1.getSongList().contains(song3));
        assertTrue(this.playlist1.getSongList().contains(song3));
        assertTrue(this.playlist1.getLength() == 2);
        assertTrue(this.playlist1.getPlaytime() == 223 + 165);
    }

    @Test
    public void removeSingleSongInPlaylistTest() {
        this.playlist3.addSong(song1);
        this.playlist3.removeSong(song1);
        assertTrue(this.playlist3.getSongList().isEmpty());
        assertFalse(this.playlist3.getSongList().contains(song1));
        assertTrue(this.playlist1.getLength() == 0);
        assertTrue(this.playlist1.getPlaytime() == 0);
    }

    @Test
    public void removeSongFromPlaylistWithSongsTest() {
        this.playlist3.addSong(song1);
        this.playlist3.addSong(song2);
        this.playlist3.addSong(song3);
        this.playlist3.removeSong(song1);
        assertFalse(this.playlist3.getSongList().isEmpty());
        assertTrue(this.playlist3.getSongList().contains(song2));
        assertTrue(this.playlist3.getSongList().contains(song3));
        assertFalse(this.playlist3.getSongList().contains(song1));
        assertEquals(this.playlist3.getLength(), 2);
        assertEquals(this.playlist3.getPlaytime(), song2.getLength() + song3.getLength());
    }


}