package com.example.qltvtt.controller;

import com.example.qltvtt.entity.Bill;

import com.example.qltvtt.entitywrapper.BillWrapper;
import com.example.qltvtt.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BillController {
    @Autowired
    private BillRepository billRepository;


    @RequestMapping(value = "/bills",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Bill> getBills() {
        return billRepository.findAll();
    }

    @RequestMapping(value = "/bill",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Bill addBill(@RequestBody Bill bil) {
        return billRepository.save(bil);
    }

    @RequestMapping(value = "/bill",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Bill updateBill(@RequestBody BillWrapper bil) {
        Bill bill = new Bill(bil);
        System.out.println("bil:" + bil);
        return billRepository.save(bill);
    }

    @RequestMapping(value = "/bill/{bilId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteAuthor(@PathVariable("bilId") Integer bilId) {
        billRepository.deleteById(bilId);
    }

    @RequestMapping(value = "bill")
    public String bill() {

        return "bill";
    }

}
