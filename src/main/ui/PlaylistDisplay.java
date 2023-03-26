package ui;

import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;

// Displays the songs in a specific playlist in a pop-up window
public class PlaylistDisplay extends JFrame {

    private JPanel panel;
    private Playlist playlist;
    private String allSongs;

    public PlaylistDisplay(Playlist playlistOfInterest) {
        playlist = playlistOfInterest;
        createPanel();
        outputSongs(playlist);
        this.setTitle("Songs in " + playlist.getName());
        this.setSize(300, 600);
        this.add(panel);
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: outputs the names of songs from the playlist via JLabels
    public void outputSongs(Playlist playlist) {
        String s = "";
        for (Song song : playlist.getSongList()) {
            s += song.getName() + "<br>";
            allSongs = "<html>" + s + "</html>";
        }
        panel.add(new JLabel(allSongs));
    }

    // MODIFIES: this
    // EFFECTS: creates panel where the list of songs in the playlist will be displayed
    public void createPanel() {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(600, 300));
    }
}
