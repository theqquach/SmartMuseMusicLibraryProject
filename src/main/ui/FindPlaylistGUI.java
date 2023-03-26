package ui;

import model.Library;
import model.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creates a pop-up window to find a specific playlist
public class FindPlaylistGUI extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField playlistNameField;
    private JLabel playlistName;
    private JButton submit;

    private Library library;
    private Playlist playlistOfInterest;

    public FindPlaylistGUI(Library playlists) {
        library = playlists;
        createPanel();
        this.setTitle("Find a Playlist");
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

        this.panel.add(playlistName);
        this.panel.add(playlistNameField);
        this.panel.add(submit);
    }

    // MODIFIES: this
    // EFFECTS: creates the text fields and buttons for panel
    public void createFieldsButtons() {
        playlistNameField = new JTextField();
        playlistNameField.setPreferredSize(new Dimension(250, 30));
        playlistName = createHeading("Playlist Name: ");

        submit = new JButton();
        submit.setText("Search");
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

    // REQUIRES: playlistOfInterest is in library
    // MODIFIES: this
    // EFFECTS: gives functionality to buttons. when button is pressed perform appropriate action.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String playlistNameInput = playlistNameField.getText();
            if (library.findPlaylist(playlistNameInput) != null) {
                playlistOfInterest = library.findPlaylist(playlistNameInput);
                this.dispose();
                new PlaylistDisplay(playlistOfInterest);
            }
        }
    }
}
