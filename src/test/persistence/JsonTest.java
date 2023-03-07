package persistence;

import model.Playlist;
import model.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlaylist(String name, int length, int playtime, Playlist playlist) {
        assertEquals(name, playlist.getName());
        assertEquals(length, playlist.getLength());
        assertEquals(playtime, playlist.getPlaytime());
    }

    protected void checkSong(String name, String artist, int length, String status, Song song) {
        assertEquals(name, song.getName());
        assertEquals(artist, song.getArtist());
        assertEquals(length, song.getLength());
        assertEquals(status, song.getStatus());
    }
}
