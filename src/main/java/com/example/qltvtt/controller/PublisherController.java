package com.example.qltvtt.controller;


import com.example.qltvtt.entity.Publisher;
import com.example.qltvtt.entitywrapper.PublisherWrapper;

import com.example.qltvtt.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublisherController {
    @Autowired
    private PublisherRepository publisherRepository;


    @RequestMapping(value = "/publishers",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @RequestMapping(value = "/publisher",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Publisher addPublisher(@RequestBody Publisher pub) {
        return publisherRepository.save(pub);
    }

    @RequestMapping(value = "/publisher",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Publisher updatePublisher(@RequestBody PublisherWrapper pub) {
        Publisher publisher = new Publisher(pub);
        System.out.println("pub:" + pub);
        return publisherRepository.save(publisher);
    }

    @RequestMapping(value = "/publisher/{pubId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deletePublisher(@PathVariable("pubId") Integer pubId) {
        publisherRepository.deleteById(pubId);
    }

    @RequestMapping(value = "publisher")
    public String publisher() {

        return "publisher";
    }
}
