package com.techelevator.controller;

import com.techelevator.dao.ApplicationsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

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

    private String formatApplication(Applications applications){
        String str = "Your application that was created on ";
        String date = LOG_FORMAT.format(applications.getCreatedDate());
        String decision = applications.getStatus();
        String admin = applications.getApprovedBy();
        str += date + " has been " + decision + " by " + admin;
        return str;
    }

}
