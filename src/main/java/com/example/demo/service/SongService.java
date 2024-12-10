package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Song;

public interface SongService {
    List<Song> getAllSongs();
    void saveSong(Song song);
    Song getSongById(long id);
    void deleteSongById(long id);
}
