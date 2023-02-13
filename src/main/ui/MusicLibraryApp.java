package ui;

import model.Playlist;
import model.PlaylistList;
import model.Song;

import java.util.Scanner;

// Music library application
public class MusicLibraryApp {

    private PlaylistList playlists;
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
        playlists = new PlaylistList();
        allSongs = new Playlist("Song Library");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tplaylists -> view all playlists");
        System.out.println("\tview playlist -> view songs in a playlist");
        System.out.println("\tsongs -> view all songs");
        System.out.println("\tnew song -> add a new song to your library");
        System.out.println("\tnew playlist -> create a new playlist");
        System.out.println("\t+ -> add a song from your library to a playlist");
        System.out.println("\t- -> remove a song from a playlist");
        System.out.println("\texit -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("playlists")) {
            viewPlaylists();
        } else if (command.equals("songs")) {
            viewSongs();
        } else if (command.equals("new song")) {
            addNewSongToLibrary();
        } else if (command.equals("new playlist")) {
            makeNewPlaylist();
        } else if (command.equals("+")) {
            addSongToPlaylist();
        } else if (command.equals("-")) {
            removeSongFromPlaylist();
        } else if (command.equals("view playlist")) {
            viewPlaylist();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: shows all playlists
    private void viewPlaylists() {
        System.out.println("Your Playlists:");
        for (int i = 0; i < this.playlists.getPlaylists().size(); ) {
            System.out.println(this.playlists.getPlaylists().get(i).getName());
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

    // MODIFIES: this
    // EFFECTS: adds new song to library
    private void addNewSongToLibrary() {
        System.out.print("Enter song name: ");
        String name = input.next();

        if (name.isEmpty()) {
            System.out.println("Please input a song name");
        } else {
            System.out.print("Enter artist name: ");
            String artist = input.next();
            if (artist.isEmpty()) {

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
    // EFFECTS: creates a new playlist with given name
    private void makeNewPlaylist() {
        System.out.print("Enter new playlist name: ");
        String name = input.next();

        if (name.isEmpty()) {
            System.out.println("Please input a playlist name");
        } else {
            Playlist playlist = new Playlist(name);
            this.playlists.getPlaylists().add(playlist);
            System.out.println("New playlist created!");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a song to a playlist
    private void addSongToPlaylist() {
        System.out.println("Enter playlist name you want to add a song to: ");
        String playlistName = input.next();
        System.out.println("Enter song name you want to add: ");
        String songName = input.next();

        if (this.playlists.findPlaylist(playlistName) != null) {
            this.playlists.findPlaylist(playlistName).addSong(allSongs.findSong(songName));
            System.out.println("Song added!");
        } else {
            System.out.println("Error");
        }

    }

    // REQUIRES: song is in playlist
    // MODIFIES: this
    // EFFECTS: removes a song to a playlist
    private void removeSongFromPlaylist() {
        System.out.println("Enter playlist name you want to remove a song from: ");
        String playlistName = input.next();
        System.out.println("Enter song name you want to remove: ");
        String songName = input.next();

        Playlist givenPlaylist = this.playlists.findPlaylist(playlistName);

        if (this.playlists.findPlaylist(playlistName) != null) {
            givenPlaylist.removeSong(givenPlaylist.findSong(songName));
            System.out.println("Song removed");
        } else {
            System.out.println("Error 2");
        }
    }


    // MODIFIES: this
    // EFFECTS: shows all songs in a specific playlist.
    private void viewPlaylist() {
        System.out.println("Enter playlist name you want to view: ");
        String playlistName = input.next();

        Playlist givenPlaylist = this.playlists.findPlaylist(playlistName);

        System.out.println(playlistName + " songs: ");
        for (int i = 0; i < givenPlaylist.getLength(); ) {
            System.out.println("\t" + givenPlaylist.getSongList().get(i).getName());
            i++;
        }
    }

}
