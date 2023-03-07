package persistence;

import model.Playlist;
import model.Library;
import model.Song;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Library library = new Library("My Library");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLibrary() {
        try {
            Library library = new Library("My Library");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLibrary.json");
            writer.open();
            writer.write(library);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLibrary.json");
            library = reader.read();
            assertEquals("My Library", library.getName());
            assertEquals(0, library.getPlaylists().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyPlaylistsToLibrary() {
        try {
            Library library = new Library("My Library");
            library.addToPlaylists(new Playlist("K-POP"));
            library.addToPlaylists(new Playlist("Taylor Swift"));
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlaylists.json");
            writer.open();
            writer.write(library);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlaylists.json");
            library = reader.read();
            assertEquals("My Library", library.getName());
            List<Playlist> playlists = library.getPlaylists();
            assertEquals(2, playlists.size());
            checkPlaylist("K-POP", 0,0, playlists.get(0));
            checkPlaylist("Taylor Swift", 0,0,playlists.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterPlaylistsWithSongsToLibrary() {
        try {
            Library library = new Library("My Library");
            Playlist playlist1 = new Playlist("K-POP");
            Playlist playlist2 = new Playlist("Swiftie Songs");
            Song song1 = new Song("OMG", "New Jeans", 300);
            Song song2 = new Song("Style", "Taylor Swift", 250);
            Song song3 = new Song("Lilac", "IU", 400);
            playlist1.addSong(song1);
            playlist1.addSong(song3);
            playlist2.addSong(song2);
            library.addToPlaylists(playlist1);
            library.addToPlaylists(playlist2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralLibrary.json");
            writer.open();
            writer.write(library);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralLibrary.json");
            library = reader.read();
            assertEquals("My Library", library.getName());
            List<Playlist> playlists = library.getPlaylists();
            assertEquals(2, playlists.size());
            checkPlaylist("K-POP", 2,700, playlists.get(0));
            checkPlaylist("Swiftie Songs", 1,250, playlists.get(1));
            checkSong("OMG", "New Jeans", 300, "none", playlists.get(0).getSongList().get(0));
            checkSong("Lilac", "IU", 400, "none", playlists.get(0).getSongList().get(1));
            checkSong("Style", "Taylor Swift", 250, "none", playlists.get(1).getSongList().get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}