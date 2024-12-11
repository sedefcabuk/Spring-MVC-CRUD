package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;

@Controller
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listSongs", songService.getAllSongs());
        return "index";
    }

    @GetMapping("/showNewSongForm")
    public String showNewSongForm(Model model) {
        Song song = new Song();
        model.addAttribute("song", song);
        return "new_song";
    }

    @PostMapping("/saveSong")
    public String saveSong(@ModelAttribute("song") Song song) {
        songService.saveSong(song);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Song song = songService.getSongById(id);

        model.addAttribute("song", song);
        return "update_song";
    }

    @GetMapping("/deleteSong/{id}")
    public String deleteSong(@PathVariable(value = "id") long id) {
        this.songService.deleteSongById(id);
        return "redirect:/";
    }
}
