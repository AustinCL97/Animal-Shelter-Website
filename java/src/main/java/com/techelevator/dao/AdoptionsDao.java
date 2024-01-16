package com.techelevator.dao;

import com.techelevator.model.Adoptions;

import java.util.List;

public interface AdoptionsDao {

    public List<Adoptions> getAdoptions(int petId);

    public Adoptions getAdoption(int petId);

    public Adoptions createAdoption(Adoptions adoption);
}
