package com.example.Recruitment.Management.System.Controller;


import com.example.Recruitment.Management.System.Entity.User;
import com.example.Recruitment.Management.System.Security.userSecEntity;
import com.example.Recruitment.Management.System.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/apply")
    public ResponseEntity<String> applyJob(@RequestParam("job_id") Long jobId,
                                           Authentication authentication) {
        User user = (User) authentication.getPrincipal();  // fixed line
        Long applicantId = user.getId();

        applicationService.applyForJob(jobId, applicantId);
        return ResponseEntity.ok("Application submitted successfully!");
    }

}

