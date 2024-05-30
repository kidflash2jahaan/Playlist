package com.system_err;

import java.util.ArrayList;
import java.util.LinkedList;
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

    private Song findSong(String title) {
        for (Song song : songs) {
            if (Objects.equals(song.getTitle(), title)) {
                return song;
            }
        }

        return null;
    }

    public void addToPlayList(int track, LinkedList<Song> playlist) {
        int index = track - 1;
        if (index >= 0 && index < songs.size()) {
            playlist.add(songs.get(track - 1));
        }
    }

    public void addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        playlist.add(song);
    }
}
