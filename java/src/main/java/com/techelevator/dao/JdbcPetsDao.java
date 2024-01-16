package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcPetsDao implements PetsDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Pets createPet(String petName, String petBreed, String petColor,
                          int petAge, boolean isAvailable, int petWeight, int zipCode,
                          String petCity, String petState) {

        Pets newPet = null;

        String sql = "INSERT INTO pets (pet_id, pet_name, pet_breed, pet_color, pet_age, is_available,\n" +
                "\t pet_description, pet_weight, pet_zip, pet_city, pet_state)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,\n" +
                "\t?,?, ?) RETURNING petId";

        try{
            int petId = jdbcTemplate.queryForObject(sql, int.class, petName, petBreed, petColor, petAge, isAvailable,
                        petWeight, zipCode, petCity, petState);

            newPet = new Pets();
            newPet.setPetId(petId);
            newPet.setPetName(petName);
            newPet.setPetBreed(petBreed);
            newPet.setPetAge(petAge);
            newPet.setIsAvailable(isAvailable);
            newPet.setPetWeight(petWeight);
            newPet.setZipCode(zipCode);
            newPet.setPetCity(petCity);
            newPet.setPetState(petState);

        }catch (Exception ex) {
            System.out.println("Something went wrong creating a new pet listing. Please try again");
        }

        return newPet;
    }

    @Override
    public Pets deletePet(int petId) {

        Pets deletedPets = null;

        String sql = "DELETE FROM pets\n" +
                "WHERE pet_id=?";

        try{
            int rowsAffected = jdbcTemplate.update(sql, petId);

            if (rowsAffected < 0){
                deletedPets = new Pets();
                deletedPets.setPetId(petId);
            } else {
                System.out.println("Pet with ID" + petId + "not found!");
            }

        }catch (Exception ex){
            System.out.println("Something went wrong with trying to delete the listing.");
        }

        return deletedPets;
    }

    @Override
    public Pets updateListing(int petId) {
        return null;
    }

    @Override
    public Pets updatePets(int petId, Pets updatedPets) {

        String sql = "UPDATE pets\n" +
                "SET \n" +
                "  pet_name = ?,\n" +
                "  pet_breed = ?,\n" +
                "  pet_color = ?,\n" +
                "  pet_age = ?,\n" +
                "  is_available = ?,\n" +
                "  pet_description = ?\n" +
                "  pet_weight = ?,\n" +
                "  zip_code = ?,\n" +
                "  pet_city = ?,\n" +
                "  pet_state = ?\n" +
                "WHERE pet_id = ?";

        try{
            int rowsAffected = jdbcTemplate.update(sql,
                    updatedPets.getPetName(),
                    updatedPets.getPetBreed(),
                    updatedPets.getPetColor(),
                    updatedPets.getPetAge(),
                    updatedPets.isAvailable(),
                    updatedPets.getPetDescription(),
                    updatedPets.getPetWeight(),
                    updatedPets.getZipCode(),
                    updatedPets.getPetCity(),
                    updatedPets.getPetState(),
                    petId);

            if(rowsAffected > 0){
                return getPetsById(petId);
            }else {
                System.out.println("Pet with ID: " + petId + " not updated.");
            }
        }catch(Exception ex){
            System.out.println("Something went wrong updating Pet record");
        }


        return null;
    }

    @Override
    public Pets getPetsById(int petId) {
        Pets pets = null;

        String sql = "SELECT ?\n" +
                "FROM pets";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
            if(results.next()){
                pets = mapRowToUser(results);
            }
        }catch (CannotGetJdbcConnectionException ex){
            throw new DaoException("Something went wrong getting pets by their ID", ex);
        }

        return pets;
    }

    private Pets mapRowToUser (SqlRowSet rs){
        Pets pets = new Pets();
        pets.setPetId(rs.getInt("pet_id"));
        pets.setPetName(rs.getString("pet_name"));
        pets.setPetBreed(rs.getString("pet_breed"));
        pets.setPetColor(rs.getString("pet_color"));
        pets.setPetAge(rs.getInt("pet_age"));
        pets.setIsAvailable(rs.getBoolean("is_available"));
        pets.setPetDescription(rs.getString("pet_description"));
        pets.setPetWeight(rs.getInt("pet_weight"));
        pets.setZipCode(rs.getInt("zip_code"));
        pets.setPetCity(rs.getString("pet_city"));
        pets.setPetState(rs.getString("pet_state"));

        return pets;
    }

}
