package com.techelevator.dao;

import com.techelevator.model.Adoptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAdoptionsDao implements AdoptionsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Adoptions> getAdoptions(int adoptionId) {
        List<Adoptions> adoptions = new ArrayList<>();

        String sql = "SELECT * FROM adoptions WHERE adoption_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, adoptionId);

            while(results.next()){
                Adoptions adoptions1 = mapRowToAdoptions(results);
                adoptions.add(adoptions1);
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
        return adoptions;
    }

    @Override
    public Adoptions getAdoption(int adoptionId) {
        Adoptions adoptions = null;

        String sql = "SELECT adoption_id FROM adoptions WHERE adoption_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, adoptionId);

            if(results.next()){
                adoptions = mapRowToAdoptions(results);
            }
        }catch (Exception ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }

        return adoptions;
    }

    @Override
    public Adoptions createAdoption(int petId, int userId, LocalDate date) {
        Adoptions newAdoptions = null;

        String sql = "INSERT INTO adoptions VALUES (?, ?, ?) RETURNING adoption_id";

        try {
            int adoptionId = jdbcTemplate.queryForObject(sql, int.class, petId, userId, date);

           newAdoptions = new Adoptions();
           newAdoptions.setAdoptionId(adoptionId);
           newAdoptions.setPetId(petId);
           newAdoptions.setUserId(userId);
           newAdoptions.setDateAdopted(date);


        } catch (Exception ex){
            System.out.println("Something went awry in creation");
        }

        return newAdoptions;
    }

    private Adoptions mapRowToAdoptions(SqlRowSet results) {
        Adoptions adoptions = new Adoptions();

        adoptions.setAdoptionId(results.getInt("adoption_id"));
        adoptions.setPetId(results.getInt("pet_id"));
        adoptions.setUserId(results.getInt("user_id"));

        if(results.getDate("date_adopted") != null) {
            adoptions.setDateAdopted(results.getDate("date_adopted").toLocalDate());
        }

        return adoptions;
    }

}
