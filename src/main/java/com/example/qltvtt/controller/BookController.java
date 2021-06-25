package com.example.qltvtt.controller;


import com.example.qltvtt.entity.Book;
import com.example.qltvtt.entitywrapper.BookWrapper;
import com.example.qltvtt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/books",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/book",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Book addBook(@RequestBody Book boo) {
        return bookRepository.save(boo);
    }

    @RequestMapping(value = "/book",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Book updateBook(@RequestBody BookWrapper boo) {
        Book book = new Book(boo);
        System.out.println("boo:" + boo);
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/book/{booId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteBook(@PathVariable("booId") Integer booId) {
        bookRepository.deleteById(booId);
    }

    @RequestMapping(value = "book")
    public String welcome() {
        return "book";
    }
}
