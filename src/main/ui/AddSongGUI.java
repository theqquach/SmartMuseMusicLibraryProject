package ui;

import model.Library;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creates a gui for user to add a song to the song library
public class AddSongGUI extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField songNameField;
    private JTextField artistField;
    private JTextField songLengthField;
    private JLabel songName;
    private JLabel artist;
    private JLabel songLength;
    private JButton submit;

    private Library library;
    private Song songToBeAdded;

    public AddSongGUI(Library playlists) {
        library = playlists;
        createPanel();
        this.setTitle("Add a Song");
        this.setSize(400, 200);
        this.setVisible(true);
        this.add(panel);
    }

    // MODIFIES: this
    // EFFECTS: creates the main panel in the GUI
    public void createPanel() {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(400, 200));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        createFieldsButtons();

        this.panel.add(songName);
        this.panel.add(songNameField);
        this.panel.add(artist);
        this.panel.add(artistField);
        this.panel.add(songLength);
        this.panel.add(songLengthField);
        this.panel.add(submit);
    }

    // MODIFIES: this
    // EFFECTS: gives functionality to buttons. when button is pressed perform appropriate action.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String songNameInput = songNameField.getText();
            String artistInput = artistField.getText();
            String songLengthInput = songLengthField.getText();
            songToBeAdded = new Song(songNameInput, artistInput, Integer.parseInt(songLengthInput));
            this.library.findPlaylist("Song Library").addSong(songToBeAdded);
            this.dispose();
        }
    }

    // MODIFIES: this
    // EFFECTS: creates the text fields and buttons for panel
    public void createFieldsButtons() {
        songNameField = new JTextField();
        songNameField.setPreferredSize(new Dimension(250, 30));
        songName = createHeading("Song Name: ");

        artistField = new JTextField();
        artistField.setPreferredSize(new Dimension(250, 30));
        artist = createHeading("Artist Name: ");

        songLengthField = new JTextField();
        songLengthField.setPreferredSize(new Dimension(250, 30));
        songLength = createHeading("Song Length: ");

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
        return new JLabel(heading);
    }

    public Song getSongToBeAdded() {
        return songToBeAdded;
    }
}
