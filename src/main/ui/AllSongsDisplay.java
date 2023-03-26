package ui;

import model.Library;
import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;

// creates pop-up window with all songs
public class AllSongsDisplay extends JFrame {

    private JPanel panel;

    private Library library;
    private Playlist allSongs;

    // MODIFIES: this
    // EFFECTS: spawns the pop-up screen to display all songs
    public AllSongsDisplay(Library playlists) {
        library = playlists;
        allSongs = library.findPlaylist("Song Library");
        outputSongs(allSongs);

        this.setTitle("Songs in your Library");
        this.setSize(300, 600);
        this.setVisible(true);
        this.setLayout(new FlowLayout(1));
    }

    // MODIFIES: this
    // EFFECTS: outputs the names of songs from a playlist via JLabels
    public void outputSongs(Playlist playlist) {
            for (Song song : playlist.getSongList()) {
                String oneSong = song.getName();
                panel.add(new JLabel(oneSong));
            }

        }
}