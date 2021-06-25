package com.example.qltvtt.controller;

import com.example.qltvtt.entity.Account;
import com.example.qltvtt.entitywrapper.AccountWrapper;
import com.example.qltvtt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/account")
    public String account() {
        return "account";
    }

    @RequestMapping(value = "/accounts",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/account",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Account addAccount(@RequestBody Account acc) {
        return accountRepository.save(acc);
    }

    @RequestMapping(value = "/account",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Account updateAccount(@RequestBody AccountWrapper acc) {
        Account account = new Account(acc);
        System.out.println("acc:" + acc);
        return accountRepository.save(account);
    }

    @RequestMapping(value = "/account/{accId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteAccount(@PathVariable("accId") Integer accId) {
        accountRepository.deleteById(accId);
    }
}
