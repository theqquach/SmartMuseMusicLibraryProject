package ui;

import model.Library;
import model.Playlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI for main screen of music library
public class MainMenuGUI extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/library.json";
    private Library playlists;
    private Playlist allSongs;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JPanel panel;
    private ImageIcon icon;

    private JButton allSongsButton;
    private JButton allPlaylistsButton;
    private JButton songsInPlaylistButton;
    private JButton newPlaylistButton;
    private JButton addNewSongButton;
    private JButton addSongToPlaylistButton;
    private JButton removeSongFromPlaylistButton;
    private JButton saveButton;
    private JButton loadButton;

    public static void main(String[] args) {
        new MainMenuGUI();
    }

    // MODIFIES: this
    // EFFECTS: creates the GUI
    public MainMenuGUI() {

        frame = new JFrame();
        panel = new JPanel();

        icon = new ImageIcon("./res/musicIcon.png");

        createButtons();

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

        frame.setTitle("SmartMuse - Music Library");
        frame.setSize(100,100);
        frame.setIconImage(icon.getImage());
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public void createButtons() {
        allSongsButton = new JButton("View all songs in library");
        allSongsButton.addActionListener(this);

        allPlaylistsButton = new JButton("View all playlists");
        allPlaylistsButton.addActionListener(this);

        songsInPlaylistButton = new JButton("View songs in a playlist");
        songsInPlaylistButton.addActionListener(this);

        newPlaylistButton = new JButton("New playlist");
        newPlaylistButton.addActionListener(this);

        addNewSongButton = new JButton("Add a new song to library");
        addNewSongButton.addActionListener(this);

        addSongToPlaylistButton = new JButton("Add a song to a playlist");
        addSongToPlaylistButton.addActionListener(this);

        removeSongFromPlaylistButton = new JButton("Remove a song from a playlist");
        removeSongFromPlaylistButton.addActionListener(this);

        saveButton = new JButton("Save library");
        saveButton.addActionListener(this);

        loadButton = new JButton("Load library");
        loadButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
