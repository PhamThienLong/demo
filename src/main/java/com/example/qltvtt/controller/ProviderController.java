package com.example.qltvtt.controller;

import com.example.qltvtt.entity.Author;
import com.example.qltvtt.entity.Provider;
import com.example.qltvtt.entitywrapper.AuthorWrapper;
import com.example.qltvtt.entitywrapper.ProviderWrapper;
import com.example.qltvtt.repository.AuthorRepository;
import com.example.qltvtt.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProviderController {
    @Autowired
    private ProviderRepository providerRepository;


    @RequestMapping(value = "/providers",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Provider> getProviders() {
        return providerRepository.findAll();
    }

    @RequestMapping(value = "/provider",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Provider addProvider(@RequestBody Provider pro) {
        return providerRepository.save(pro);
    }

    @RequestMapping(value = "/provider",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Provider updateProvider(@RequestBody ProviderWrapper pro) {
        Provider provider = new Provider(pro);
        System.out.println("pro:" + pro);
        return providerRepository.save(provider);
    }

    @RequestMapping(value = "/provider/{proId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteProvider(@PathVariable("proId") Integer proId) {
        providerRepository.deleteById(proId);
    }

    @RequestMapping(value = "provider")
    public String provider() {

        return "provider";
    }
}
