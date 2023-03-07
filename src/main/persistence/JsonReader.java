package persistence;

import model.Library;
import model.Playlist;
import model.Song;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads Library from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Library from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Library read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLibrary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Library from JSON object and returns it
    private Library parseLibrary(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Library lib = new Library(name);
        addPlaylists(lib, jsonObject);
        return lib;
    }

    // MODIFIES: lib
    // EFFECTS: parses playlists from JSON object and adds them to Library
    private void addPlaylists(Library lib, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("playlists");
        for (Object json : jsonArray) {
            JSONObject nextPlaylist = (JSONObject) json;
            addPlaylist(lib, nextPlaylist);

        }
    }

    // MODIFIES: lib
    // EFFECTS: parses playlist from JSON object and adds it to Library
    private void addPlaylist(Library lib, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Playlist playlist = new Playlist(name);
        addSongs(playlist, jsonObject);
        lib.addToPlaylists(playlist);
    }

    // MODIFIES: playlist
    // EFFECTS: parses songs from JSON object and adds it to playlist
    private void addSongs(Playlist playlist, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("songList");
        for (Object json : jsonArray) {
            JSONObject nextSong = (JSONObject) json;
            addSong(playlist, nextSong);
        }
    }

    // MODIFIES: playlist
    // EFFECTS: parses song from JSON object and adds it to playlist
    private void addSong(Playlist playlist, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String artist = jsonObject.getString("artist");
        int length = Integer.valueOf(jsonObject.getString("length"));
        String status = jsonObject.getString("status");
        Song song = new Song(name, artist, length);

        if (status.equals("favourited")) {
            song.favouriteSong();
        } else if (status.equals("disliked")) {
            song.dislikeSong();
        }
        playlist.addSong(song);
    }
}
