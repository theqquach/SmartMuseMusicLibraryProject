package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    private Song song1;
    private Song song2;
    private Song song3;

    @BeforeEach
    public void setup() {
        this.song1 = new Song("Red", "Taylor Swift", 223);
        this.song2 = new Song("OMG", "NewJeans", 212);
        this.song3 = new Song("what would you do?", "Tate McRae", 165);

    }

    @Test
    public void favouriteSongTest() {
        this.song1.favouriteSong();
        assertEquals(song1.getStatus(), "favourited");
        assertEquals(song1.getLength(), 223);
        assertEquals(song1.getArtist(), "Taylor Swift");
        assertEquals(song1.getName(), "Red");
    }

    @Test
    public void favouriteDislikedSongTest() {
        this.song2.dislikeSong();
        this.song2.favouriteSong();
        assertEquals(song2.getStatus(), "favourited");
        assertEquals(song2.getLength(), 212);
        assertEquals(song2.getArtist(), "NewJeans");
        assertEquals(song2.getName(), "OMG");
    }

    @Test
    public void favouriteFavouritedSongTest() {
        this.song3.favouriteSong();
        this.song3.favouriteSong();
        assertEquals(song3.getStatus(), "favourited");
        assertEquals(song3.getLength(), 165);
        assertEquals(song3.getArtist(), "Tate McRae");
        assertEquals(song3.getName(), "what would you do?");
    }

    @Test
    public void dislikeSongTest() {
        this.song1.dislikeSong();
        assertEquals(song1.getStatus(), "disliked");
    }

    @Test
    public void dislikeFavouritedSongTest() {
        this.song2.favouriteSong();
        this.song2.dislikeSong();
        assertEquals(song2.getStatus(), "disliked");
    }

    @Test
    public void dislikeDislikedSongTest() {
        this.song3.dislikeSong();
        this.song3.dislikeSong();
        assertEquals(song3.getStatus(), "disliked");
    }

    @Test
    public void resetStatusFromNoneTest() {
        this.song1.resetStatus();
        assertEquals(song1.getStatus(), "none");
    }

    @Test
    public void resetStatusFromFavTest() {
        this.song2.favouriteSong();
        this.song2.resetStatus();
        assertEquals(song2.getStatus(), "none");
    }

    @Test
    public void resetStatusFromDislikedTest() {
        this.song3.dislikeSong();
        this.song3.resetStatus();
        assertEquals(song3.getStatus(), "none");
    }
}