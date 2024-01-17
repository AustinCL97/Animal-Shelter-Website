package com.techelevator.dao;

import com.techelevator.model.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotosDao implements PhotosDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Photos addPhoto(Photos photos) {
        Photos newPhotos = null;

        String sql = "INSERT INTO photos(photo_URL, pet_id) VALUES( ?, ?) returning photo_id";

        try{
            int photoId = jdbcTemplate.queryForObject(sql, int.class, photos.getPhotoUrl(), photos.getPetId());

            newPhotos = getPhoto(photoId);

        } catch (Exception ex){
            System.out.println("Something went Awry creating photo: ");
        }
        return newPhotos;
    }

    @Override
    public Photos getPhoto(int photoId) {
        Photos photos = null;

        String sql = "SELECT photo_URL, photo_id, pet_id FROM photos WHERE photo_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, photoId);

            if(results.next()){
                photos = mapRowToPhotos(results);
            }
        }catch (Exception ex){
            System.out.println("Something went Awry getting Photo: " + ex.getMessage());
        }
        return photos;
    }

    @Override
    public List<Photos> getPhotos(int petId) {
        List<Photos> photos = new ArrayList<>();

        String sql = "SELECT * FROM photos WHERE pet_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);

            while(results.next()){
                Photos photo = mapRowToPhotos(results);
                photos.add(photo);
            }

        }catch (Exception ex){
            System.out.println("Something went Awry gettingPhotos: " + ex.getMessage());
        }


        return photos;
    }

    @Override
    public int removePhoto(int photoId) {
        int numberRows = 0;

        String sql = "DELETE FROM photos WHERE photo_id = ?;";

        try{
            numberRows = jdbcTemplate.update(sql, photoId);

        }catch(Exception ex){
            System.out.println("Something went wrong removing photo: " + ex.getMessage());
        }
        return numberRows;
    }


    private Photos mapRowToPhotos(SqlRowSet results){
        Photos photos = new Photos();

        photos.setPhotoId(results.getInt("photo_id"));
        photos.setPhotoUrl(results.getString("photo_URL"));
        photos.setPetId(results.getInt("pet_id"));

        return photos;
    }

}
