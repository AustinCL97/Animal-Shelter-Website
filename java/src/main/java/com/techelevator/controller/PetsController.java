package com.techelevator.controller;

import com.techelevator.dao.PetsDao;
import com.techelevator.model.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("/pets")
public class PetsController {

   // private static final String API_BASE_PATH = "/pets/" ;
    @Autowired
    private PetsDao petsDao;

    @GetMapping(path="/{petId}")
    public Pets getPet(@PathVariable int petId){
        return petsDao.getPetsById(petId);
    }
    @RequestMapping("/available")
    public Pets availablePets(@RequestParam boolean isAvailable){
        return petsDao.isAvailable(isAvailable);
    }

}
