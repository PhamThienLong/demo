package com.example.qltvtt.controller;

import com.example.qltvtt.entity.Author;
import com.example.qltvtt.entitywrapper.AuthorWrapper;
import com.example.qltvtt.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping(value = "/authors",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @RequestMapping(value = "/author",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Author addAuthor(@RequestBody Author aut) {
        return authorRepository.save(aut);
    }

    @RequestMapping(value = "/author",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Author updateAuthor(@RequestBody AuthorWrapper aut) {
        Author author = new Author(aut);
        System.out.println("aut:" + aut);
        return authorRepository.save(author);
    }

    @RequestMapping(value = "/author/{autId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteAuthor(@PathVariable("autId") Integer autId) {
        authorRepository.deleteById(autId);
    }

    @RequestMapping(value = "author")
    public String author() {

        return "author";
    }
}
