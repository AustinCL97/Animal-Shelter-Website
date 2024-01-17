package com.techelevator.controller;

import com.techelevator.dao.AdoptionsDao;
import com.techelevator.model.Adoptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/adoptions")
public class AdoptionsController {

    @Autowired
    private AdoptionsDao adoptionsDao;

    @RequestMapping(path="/{adoptionId}", method = RequestMethod.GET)
    public Adoptions getAdoption(@PathVariable int adoptionId){
        return adoptionsDao.getAdoption(adoptionId);
    }

    @RequestMapping(path="/pets/{adoptionId}", method = RequestMethod.GET)
    public List<Adoptions> getAdoptions(@PathVariable int adoptionId){
        return adoptionsDao.getAdoptions(adoptionId);
    }

    @RequestMapping(path="/add" , method = RequestMethod.POST)
    public Adoptions createAdoption(@RequestBody Adoptions adoptions){
        return adoptionsDao.createAdoption(adoptions);
    }

}
