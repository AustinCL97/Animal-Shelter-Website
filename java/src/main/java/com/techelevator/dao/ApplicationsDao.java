package com.techelevator.dao;

import com.techelevator.model.Applications;

import java.util.List;

public interface ApplicationsDao {
    Applications getAppByAppId(int applicationId);
    List<Applications> getAppsByUserId(int userId);
    void createApplication(Applications applications);
    Applications approve(int applicationId, String admin);
    Applications reject(int applicationId, String admin);

}
