package ui;

import model.Playlist;
import model.Song;

import java.util.ArrayList;
import java.util.Scanner;

// Music library application
public class MusicLibraryApp {

    private ArrayList<Playlist> playlists;
    private Playlist allSongs;
    private Scanner input;

    // EFFECTS: runs the music library application
    public MusicLibraryApp() {
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("exit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes library
    private void init() {
        playlists = new ArrayList<Playlist>();
        allSongs = new Playlist("Song Library");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tplaylists -> view all playlists");
        System.out.println("\tsongs -> view all songs");
        System.out.println("\t+ -> add a new song to your library");
        System.out.println("\texit -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("playlists")) {
            viewPlaylists();
        } else if (command.equals("songs")) {
            viewSongs();
        } else if (command.equals("+")) {
            addNewSongToLibrary();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds new song to library
    private void addNewSongToLibrary() {
        System.out.print("\nEnter song name: ");
        String name = input.next();

        if (name.isBlank()) {
            System.out.println("Please input a song name");
        } else {
            System.out.print("Enter artist name: ");
            String artist = input.next();
            if (artist.isBlank()) {

                System.out.println("Please input an artist");
            } else {
                System.out.println("Enter song length (seconds): ");
                int length = input.nextInt();
                if (length <= 0) {
                    System.out.println("Song length must be greater than 0 seconds");
                } else {
                    Song newSong = new Song(name, artist, length);
                    this.allSongs.addSong(newSong);
                    System.out.println("New song added!");
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: shows all playlists
    private void viewPlaylists() {
        System.out.println("Your Playlists:");
        for (int i = 0; i < this.playlists.size(); ) {
            System.out.println(this.playlists.get(i).getName());
            i++;
        }
    }

    // MODIFIES: this
    // EFFECTS: shows all songs
    private void viewSongs() {
        System.out.println("Your Songs:");
        for (int i = 0; i < this.allSongs.getLength(); ) {
            System.out.println(this.allSongs.getSongList().get(i).getName());
            i++;
        }
    }
}
