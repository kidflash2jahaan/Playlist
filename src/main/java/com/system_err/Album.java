package com.system_err;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Album {
    String name;
    String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addSong(String title, double duration) {
        Song song = new Song(title, duration);
        songs.add(song);
    }

    public void addToPlayList(int track, LinkedList<Song> playlist) {
        playlist.add(new SongList(songs).findSong(track));
    }

    public void addToPlayList(String title, LinkedList<Song> playlist) {
        playlist.add(new SongList(songs).findSong(title));
    }

    public static class SongList {
        private static List<Song> songs;

        private SongList(List<Song> songs) {
            SongList.songs = songs;
        }
        
        private void add(Song song) {
            if (!songs.contains(song)) {
                songs.add(song);
            }
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (Objects.equals(song.getTitle(), title)) {
                    return song;
                }
            }

            System.out.println("The song " + title + " is not in this album");
            return null;
        }
        
        private Song findSong(int track) {
            int index = track - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }

            System.out.println("This album does not have a track " + track);
            return null;
        }
    }
}
