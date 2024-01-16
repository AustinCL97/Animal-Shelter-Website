package com.techelevator.dao;

import com.techelevator.model.Photos;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;

public interface PhotosDao {

    public Photos createPhoto(String name, int petId, LocalDate date);

    public Photos getPhoto(int photoId);

    public List<Photos> getPhotos(int adoptionId);

}
