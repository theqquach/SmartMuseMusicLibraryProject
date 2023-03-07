package persistence;

import model.Library;
import model.Playlist;
import model.Song;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Library library = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyLibrary() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLibrary.json");
        try {
            Library library = reader.read();
            assertEquals("My Library", library.getName());
            assertEquals(0, library.getPlaylists().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmptyPlaylists() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlaylists.json");
        try {
            Library library = reader.read();
            assertEquals("My Library", library.getName());
            List<Playlist> playlists = library.getPlaylists();
            assertEquals(2, playlists.size());
            checkPlaylist("K-POP", 0, 0, playlists.get(0));
            checkPlaylist("Taylor Swift", 0, 0, playlists.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralLibrary() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralLibrary.json");
        try {
            Library library = reader.read();
            assertEquals("My Library", library.getName());
            List<Playlist> playlists = library.getPlaylists();
            assertEquals(2, playlists.size());
            checkPlaylist("K-POP", 2, 700, playlists.get(0));
            checkPlaylist("Swiftie Songs", 1, 250, playlists.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void favouritedSongInLibraryTest() {
        JsonReader reader = new JsonReader("./data/testReaderFavouriteTest.json");
        try {
            Library library = reader.read();
            assertEquals("My Library", library.getName());
            assertEquals(1, library.getPlaylists().size());
            checkPlaylist("K-POP", 1, 300, library.getPlaylists().get(0));
            checkSong("OMG", "New Jeans", 300, "favourited", library.getPlaylists().get(0).getSongList().get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void dislikedSongInLibraryTest() {
        JsonReader reader = new JsonReader("./data/testReaderDislikeTest.json");
        try {
            Library library = reader.read();
            assertEquals("My Library", library.getName());
            assertEquals(1, library.getPlaylists().size());
            checkPlaylist("Pop", 1, 240, library.getPlaylists().get(0));
            checkSong("Bad Blood", "Taylor Swift", 240, "disliked", library.getPlaylists().get(0).getSongList().get(0));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}