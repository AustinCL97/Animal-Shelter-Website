package com.techelevator.controller;

import com.techelevator.model.Email;
import com.techelevator.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/email")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/approved")
    String sendApproval(@RequestBody Email email){
        this.emailService.sendMessage(email.getEmail(), "Application Approved",
                "Congratulations, your request to become a volunteer " +
                        "here at Parker's Pets has been approved! An admin from our volunteer team " +
                        "will be in touch soon with next steps.");
        return "Message Sent";
    };

    @PostMapping("/denied")
    String sendDenial(@RequestBody Email email){
        this.emailService.sendMessage(email.getEmail(), "Application Denied",
                "Thank you for your interest in being a volunteer here at " +
                        "Parker's Pets. Unfortunately your application has been denied. " +
                        "This is usually do to a lack of available spaces so feel free to " +
                        "reach out in the future. ");

        return "Message Sent";
    }
}
