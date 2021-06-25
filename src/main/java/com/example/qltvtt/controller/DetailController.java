package com.example.qltvtt.controller;


import com.example.qltvtt.entity.Detail;
import com.example.qltvtt.entitywrapper.DetailWrapper;
import com.example.qltvtt.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DetailController {

    @Autowired
    private DetailRepository detailRepository;

    @RequestMapping("/detail")
    public String welcome() {
        return "detail";
    }

    @RequestMapping(value = "/details",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Detail> getDetails() {
        return detailRepository.findAll();
    }

    @RequestMapping(value = "/detail",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Detail addDetail(@RequestBody Detail det) {
        return detailRepository.save(det);
    }

    @RequestMapping(value = "/detail",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Detail updateDetail(@RequestBody DetailWrapper det) {
        Detail detail = new Detail(det);
        System.out.println("det:" + det);
        return detailRepository.save(detail);
    }

    @RequestMapping(value = "/detail/{detId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteDetail(@PathVariable("detId") Integer detId) {
        detailRepository.deleteById(detId);
    }
}
