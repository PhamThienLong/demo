package com.example.qltvtt.controller;

import com.example.qltvtt.entity.Author;
import com.example.qltvtt.entity.Genre;
import com.example.qltvtt.entitywrapper.AuthorWrapper;

import com.example.qltvtt.entitywrapper.GenreWrapper;
import com.example.qltvtt.repository.AuthorRepository;
import com.example.qltvtt.repository.EmployeeRepository;
import com.example.qltvtt.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;


    @RequestMapping(value = "/genres",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @RequestMapping(value = "/genre",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Genre addGenre(@RequestBody Genre gen) {
        return genreRepository.save(gen);
    }

    @RequestMapping(value = "/genre",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Genre updateGenre(@RequestBody GenreWrapper gen) {
        Genre genre = new Genre(gen);
        System.out.println("gen:" + gen);
        return genreRepository.save(genre);
    }

    @RequestMapping(value = "/genre/{genId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteGenre(@PathVariable("genId") Integer genId) {
        genreRepository.deleteById(genId);
    }

    @RequestMapping(value = "genre")
    public String genre() {

        return "genre";
    }
}
