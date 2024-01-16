package com.techelevator.dao;

import com.techelevator.model.Adoptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAdoptionsDao implements AdoptionsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Adoptions> getAdoptions(int petId) {
        return null;
    }

    @Override
    public Adoptions getAdoption(int petId) {
        return null;
    }

    @Override
    public Adoptions createAdoption(Adoptions adoption) {
        return null;
    }
}
