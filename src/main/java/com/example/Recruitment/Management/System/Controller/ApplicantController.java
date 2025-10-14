package com.example.Recruitment.Management.System.Controller;


import com.example.Recruitment.Management.System.Entity.Profile;
import com.example.Recruitment.Management.System.Entity.User;
import com.example.Recruitment.Management.System.Services.ApplicantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    // Admin: list all applicants
    @GetMapping("/applicants")
    public ResponseEntity<List<User>> getAllApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }

    // Admin: get extracted data of applicant
    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<Profile> getApplicantProfile(@PathVariable Long applicantId) {
        return ResponseEntity.ok(applicantService.getApplicantProfile(applicantId));
    }
}
