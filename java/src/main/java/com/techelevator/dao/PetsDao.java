package com.techelevator.dao;
import com.techelevator.model.Pets;

public interface PetsDao {

    Pets createPet(String petName, String petBreed, String petColor,  int petAge, boolean isAvailable,
                      int petWeight, int zipCode, String petCity, String petState);
    Pets deletePet(int petId);

    Pets updateListing(int petId);

    Pets updatePets(int petId, Pets updatedPets);

    Pets getPetsById(int petId);

}
