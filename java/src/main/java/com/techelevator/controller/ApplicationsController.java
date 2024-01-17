package com.techelevator.controller;

import com.techelevator.dao.ApplicationsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class ApplicationsController {
    @Autowired
    private ApplicationsDao applicationsDao;
    @Autowired
    private UserDao userDao;

    private static final String API_BASE_PATH = "/Applications/";
    private static final DateTimeFormatter LOG_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @RequestMapping(path = API_BASE_PATH + "{id}", method = RequestMethod.GET)
    public String getAppStatusById(@PathVariable int id, Principal principal){
        String status = "";
        Applications applications = applicationsDao.getAppByAppId(id);
        status += formatApplication(applications);
        return status;
    }

    @RequestMapping(path = API_BASE_PATH, method = RequestMethod.GET)
    public List<Applications> volunteerDirectory(){
        return applicationsDao.getAllVolunteers();
    }

    @RequestMapping(path = API_BASE_PATH + "apply", method = RequestMethod.POST)
    public String applyToBeVolunteer(@RequestBody Applications applications){
        applicationsDao.createApplication(applications);
        String success = "Your application has been submitted";
        return success;
    }
    @RequestMapping(path = API_BASE_PATH + "{id}" + "/approve", method = RequestMethod.PUT)
    public String approveVolunteer(@PathVariable int id,Principal principal){
        applicationsDao.approve(id,principal.getName());
        Applications applications = applicationsDao.getAppByAppId(id);
        String approved = "The application for " + applications.getAppName() + " has been approved!";
        return approved;
    }
    @RequestMapping(path = API_BASE_PATH + "{id}" + "/reject", method = RequestMethod.PUT)
    public String rejectVolunteer(@PathVariable int id,Principal principal){
        applicationsDao.reject(id,principal.getName());
        Applications applications = applicationsDao.getAppByAppId(id);
        String rejected = "The application for " + applications.getAppName() + " has been rejected.";
        return rejected;
    }


    private String formatApplication(Applications applications){
        String str = "Your application that was created on ";
        String date = LOG_FORMAT.format(applications.getCreatedDate());
        String decision = applications.getStatus();
        String admin = applications.getApprovedBy();
        if(Objects.equals(applications.getStatus(), "pending")){
            str += date + " is currently " + decision;
        } else {
            str += date + " has been " + decision + " by " + admin;
        }
        return str;
    }

}
