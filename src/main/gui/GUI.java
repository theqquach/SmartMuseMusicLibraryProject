package gui;

import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public GUI() {

        JButton allSongsButton = new JButton("View all songs in library");
        JButton allPlaylistsButton = new JButton("View all playlists");
        JButton songsInPlaylistButton = new JButton("View songs in a playlist");
        JButton newPlaylistButton = new JButton("New playlist");
        JButton addNewSongButton = new JButton("Add a new song to library");
        JButton addSongToPlaylistButton = new JButton("Add a song to a playlist");
        JButton removeSongFromPlaylistButton = new JButton("Remove a song from a playlist");
        JButton saveButton = new JButton("Save library");
        JButton loadButton = new JButton("Load library");

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(3, 2));
        panel.add(allSongsButton);
        panel.add(addNewSongButton);
        panel.add(newPlaylistButton);
        panel.add(allPlaylistsButton);
        panel.add(addSongToPlaylistButton);
        panel.add(saveButton);
        panel.add(songsInPlaylistButton);
        panel.add(removeSongFromPlaylistButton);
        panel.add(loadButton);

        frame.setSize(100,100);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Music Library");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
