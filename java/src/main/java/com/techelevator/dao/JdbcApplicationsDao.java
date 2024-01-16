package com.techelevator.dao;

import com.techelevator.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcApplicationsDao implements ApplicationsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Applications getAppByAppId(int applicationId){
        Applications applications = null;
        String sql = "SELECT * \n" +
                "FROM applications\n" +
                "WHERE applicant_id = ?;";
        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,applicationId);
            if(rowSet.next()){
                applications = mapRowToApplication(rowSet);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong getting aan Application by its ID");
        }
        return applications;
    }
    public List<Applications> getAppsByUserId(int userId){
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT * \n" +
                "FROM applications\n" +
                "WHERE user_id = ?;";
        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId);
            while(rowSet.next()){
                applicationsList.add(mapRowToApplication(rowSet));
            }

        } catch (Exception e){
            System.out.println("Something went wrong getting a list of Applications");
        }
        return applicationsList;
    }

    public void createApplication(Applications applications){
        String sql = "INSERT INTO applications(user_id,app_email,app_name,app_phonenumber,application_date)\n" +
                "VALUES(?,?,?,?, NOW());";

        try{
            int applicationId = 0;
            applicationId = jdbcTemplate.queryForObject(sql, int.class, applications.getUserId(),applications.getAppEmail(),applications.getAppName(),applications.getAppPhoneNumber());
            applications.setApplicationId(applicationId);

        } catch (Exception e){
            System.out.println("Something went wrong creating an Application");
        }
    }
    public Applications approve(int applicationId, String admin){
        Applications applications = null;
        String sql = "UPDATE applications\n" +
                "SET status = 'Approved', approved_by = ?\n" +
                "WHERE applicant_id = ?;";
        try{
            int rowsAffected;
            rowsAffected = jdbcTemplate.update(sql, admin, applicationId);
            if(rowsAffected == 0){
                throw new Exception("no rows affected");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong approving an Application");
        }
        return applications;
    }
    public Applications reject(int applicationId, String admin){
        Applications applications = null;
        String sql = "UPDATE applications\n" +
                "SET status = 'Rejected', approved_by = ?\n" +
                "WHERE applicant_id = ?;";
        try{
            int rowsAffected;
            rowsAffected = jdbcTemplate.update(sql, admin, applicationId);
            if(rowsAffected == 0){
                throw new Exception("no rows affected");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong rejected an Application");
        }
        return applications;
    }

    private Applications mapRowToApplication(SqlRowSet rs){
        Applications applications = new Applications();
        applications.setApplicationId(rs.getInt("applicant_id"));
        applications.setUserId(rs.getInt("user_id"));
        applications.setAppEmail(rs.getString("app_email"));
        applications.setAppName(rs.getString("app_name"));
        applications.setAppPhoneNumber(rs.getString("app_phonenumber"));
        applications.setStatus(rs.getString("status"));
        applications.setCreatedDate(rs.getTimestamp("application_date").toLocalDateTime());
        applications.setApprovedBy(rs.getString("approved_by"));
        return applications;
    }

}
