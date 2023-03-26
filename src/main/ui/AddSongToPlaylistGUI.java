package ui;

import model.Library;
import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creates a pop-up window for user to input song to add and playlist to add to
public class AddSongToPlaylistGUI extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField songNameField;
    private JTextField playlistNameField;
    private JLabel songName;
    private JLabel playlistName;
    private JButton submit;

    private Library library;
    private Song songToBeAdded;
    private Playlist playlistAddedTo;

    public AddSongToPlaylistGUI(Library playlists) {
        library = playlists;
        createPanel();
        this.setTitle("Add a Song to a Playlist");
        this.setSize(400, 200);
        this.setVisible(true);
        this.add(panel);
    }

    // MODIFIES: this
    // EFFECTS: creates the main panel in the GUI
    public void createPanel() {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(400, 200));
        this.panel.setLayout(new FlowLayout(1));
        createFieldsButtons();

        this.panel.add(songName);
        this.panel.add(songNameField);
        this.panel.add(playlistName);
        this.panel.add(playlistNameField);
        this.panel.add(submit);
    }

    // MODIFIES: this
    // EFFECTS: creates the text fields and buttons for panel
    public void createFieldsButtons() {
        songNameField = new JTextField();
        songNameField.setPreferredSize(new Dimension(250, 30));
        songName = createHeading("Name of Song to be added: ");

        playlistNameField = new JTextField();
        playlistNameField.setPreferredSize(new Dimension(250, 30));
        playlistName = createHeading("Name of Playlist to add to: ");

        submit = new JButton();
        submit.setText("Submit");
        submit.addActionListener(this);
        submit.setPreferredSize(new Dimension(100, 20));
        submit.setHorizontalAlignment(JButton.CENTER);
        submit.setVerticalTextPosition(JButton.BOTTOM);
    }

    // MODIFIES: this
    // EFFECTS: creates JLabel headings
    public JLabel createHeading(String heading) {
        JLabel header = new JLabel(heading);
        return header;
    }

    // REQUIRES: song and playlist exist and are in library
    // MODIFIES: this
    // EFFECTS: creates response for button inputs. If button is pressed it does corresponding action.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String songNameInput = songNameField.getText();
            String playlistNameInput = playlistNameField.getText();
            songToBeAdded = library.findPlaylist("Song Library").findSong(songNameInput);
            playlistAddedTo = library.findPlaylist(playlistNameInput);
            this.dispose();
        }
    }

    public Song getSongToBeAdded() {
        return songToBeAdded;
    }

    public Playlist getPlaylistAddedTo() {
        return playlistAddedTo;
    }
}
