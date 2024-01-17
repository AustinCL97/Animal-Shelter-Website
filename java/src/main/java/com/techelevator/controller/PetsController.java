package com.techelevator.controller;

import com.techelevator.dao.PetsDao;
import com.techelevator.model.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



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
    @GetMapping("/available")
    public List<Pets> availablePets(@RequestParam boolean isAvailable){
        return petsDao.isAvailable(isAvailable);
    }

    @PostMapping("/addNew")
    public Pets createPet(@RequestBody Pets pet) {
        return petsDao.createPet(pet);
    }
   
}
