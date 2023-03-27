package ui;

import model.Library;
import model.Playlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// GUI for main screen of music library
public class MusicLibraryGUI extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/library.json";
    private Library playlists;
    private Playlist allSongs;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JPanel panel;
    private JPanel botPanel;
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

    // MODIFIES: this
    // EFFECTS: creates the GUI
    public MusicLibraryGUI() {
        init();
        createButtons();
        setupLogo();
        setupPanel();
        setupFrame();
    }

    // MODIFIES: this
    // EFFECTS: sets up the JFrame for the GUI
    private void setupFrame() {
        frame.setTitle("SmartMuse - Music Library");
        frame.setSize(100, 100);
        frame.setIconImage(icon.getImage());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(botPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up the panel for the buttons
    private void setupPanel() {
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
    }

    // MODIFIES: this
    // EFFECTS: sets up the bottom panel for the GUI
    private void setupLogo() {
        JLabel label = new JLabel();
        label.setIcon(icon);
        botPanel.add(label);
    }

    // MODIFIES: this
    // EFFECTS: creates the buttons for the UI
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

    // MODIFIES: this
    // EFFECTS: initializes the variables for the MusicLibraryGUI
    private void init() {
        playlists = new Library("Your Library");
        allSongs = new Playlist("Song Library");
        playlists.addToPlaylists(allSongs);
        frame = new JFrame();
        panel = new JPanel();
        botPanel = new JPanel();
        icon = new ImageIcon("./res/musicIcon.png");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: creates response for button inputs. If button is pressed it does corresponding action.
    @Override
    @SuppressWarnings("methodlength")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allSongsButton) {
            new AllSongsDisplay(playlists);
        }
        if (e.getSource() == allPlaylistsButton) {
            new AllPlaylistDisplay(playlists);
        }
        if (e.getSource() == songsInPlaylistButton) {
            new FindPlaylistGUI(playlists);
        }
        if (e.getSource() == addNewSongButton) {
            AddSongGUI asg = new AddSongGUI(playlists);
            if (asg.getSongToBeAdded() != null) {
                playlists.findPlaylist("Song Library").addSong(asg.getSongToBeAdded());
            }
        }
        if (e.getSource() == newPlaylistButton) {
            AddPlaylistGUI apg = new AddPlaylistGUI(playlists);
            if (apg.getPlaylistToBeAdded() != null) {
                playlists.addToPlaylists(apg.getPlaylistToBeAdded());
            }
        }
        if (e.getSource() == addSongToPlaylistButton) {
            AddSongToPlaylistGUI astpg = new AddSongToPlaylistGUI(playlists);
            if (astpg.getPlaylistAddedTo() != null && astpg.getSongToBeAdded() != null) {
                playlists.findPlaylist(astpg.getPlaylistAddedTo().getName()).addSong(astpg.getSongToBeAdded());
            }
        }
        if (e.getSource() == removeSongFromPlaylistButton) {
            RemoveFromPlaylistGUI rfpg = new RemoveFromPlaylistGUI(playlists);
            if (rfpg.getSongToBeRemoved() != null && rfpg.getPlaylistRemovedFrom() != null) {
                playlists.findPlaylist(rfpg.getPlaylistRemovedFrom().getName()).removeSong(rfpg.getSongToBeRemoved());
            }
        }
        if (e.getSource() == saveButton) {
            save();
        }
        if (e.getSource() == loadButton) {
            load();
        }
    }

    // MODIFIES: this
    // EFFECTS: saves the current state of the library
    private void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(playlists);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Library Saved", "Note:", JOptionPane.PLAIN_MESSAGE);
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "Unable to write file", "Error:", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the previous data from file into the library
    private void load() {
        try {
            playlists = jsonReader.read();
            JOptionPane.showMessageDialog(null, "Loaded saved library", "Note:", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Unable to read file", "Error:", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
