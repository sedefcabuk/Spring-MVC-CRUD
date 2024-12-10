package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Song;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public void saveSong(Song song) {
        this.songRepository.save(song);
    }

    @Override
    public Song getSongById(long id) {
        Optional<Song> optional = songRepository.findById(id);
        Song song = null;
        if (optional.isPresent()) {
            song = optional.get();
        } else {
            throw new RuntimeException(id + "id numarasına sahip şarkı bulunamadı");
        }
        return song;
    }

    @Override
    public void deleteSongById(long id) {
        this.songRepository.deleteById(id);
    }
}
