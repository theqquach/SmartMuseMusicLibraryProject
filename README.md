# SmartMuse: A music library 

### Description:

#### What will the application do?
The program will store songs and playlists. Specifically, it will be able to hold song name, artist name and song length
for songs in its library. The user will be able to add and create playlists. The user can see all songs in the playlist 
and add new songs to their library. Additionally, there will be a feature to favourite or dislike songs so that they 
organize their music preferences.


#### Who will use it?
Anyone who enjoys listening to music and wants to organize it.  

#### Why is this project of interest to you?
I love listening to music, and love making playlists for different moods, settings or activities. 

### User Stories:
- As a user, I want to add songs to my music library.
- As a user, I want to add songs to my own playlists.
- As a user, I want to save a created playlist to my music library.
- As a user, I want to mark songs as "favourited" and "disliked" so I can see them separately.
- As a user, I want to see all my songs and playlists in my library.
- As a user, I want to have the option to save my library.
- As a user, I want to be able to load my library from file.
 
## Attribution:
- UI draws from TellerApp's UI implementation.
- Data persistence draws from JSONSerialization's persistence implementation.
- GUI created with various online resources such as javatpoint.com and YouTuber Alex Lee.
- Event Logging draws from AlarmSystem's Event and EventLog classes.

# Instructions for Grader: 
- Create a song and playlist with the "Add a new song to library" and "New playlist" buttons. You can then add a song to
  a playlist by selecting the "Add a song to a playlist" button. 
- You can remove songs from playlists with the "Remove song from playlist" button.
- You can view all song by pressing the "View all songs in library" button. Or you can view songs in a specific playlist
  by pressing "View songs in a playlist" and inputting the desired playlist to view.
- You can view playlist names with the "View all playlists" button.
- My visual component is located at the bottom of the main menu of the library.
- You can save the state of my application by hitting the save button.
- You can reload the state of my application by hitting the load button.

# Phase 4: Task 2:

Sample of event log console print out:

Event Log:
Sat Apr 08 14:14:53 PDT 2023
new playlist added
Sat Apr 08 14:21:59 PDT 2023
new playlist added
Sat Apr 08 14:22:17 PDT 2023
song added to playlist
Sat Apr 08 14:22:33 PDT 2023
song added to playlist
Sat Apr 08 14:22:51 PDT 2023
song found in given playlist
Sat Apr 08 14:22:51 PDT 2023
song added to playlist
Sat Apr 08 14:22:56 PDT 2023
song found in given playlist
Sat Apr 08 14:22:56 PDT 2023
song added to playlist
Sat Apr 08 14:23:03 PDT 2023
song found in given playlist
Sat Apr 08 14:23:03 PDT 2023
song removed from playlist
Sat Apr 08 14:23:14 PDT 2023

# Phase 4: Task 3:

One thing I would do with more time is refactor the Display classes. In the AllPlaylistDisplay, AllSongsDisplay, and 
PlaylistDisplay classes, there is a lot of repetitive code. To refactor this, I would implement an abstract class, 
Display, with methods that are similar in these classes and have the classes extend the Display class. This would reduce
the amount of repetitive code in my program. This would allow the display to be created while each class would simply 
change what is displayed in the window.


