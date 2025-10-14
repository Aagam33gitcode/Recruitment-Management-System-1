package com.example.Recruitment.Management.System.Controller;


import com.example.Recruitment.Management.System.Entity.Profile;
import com.example.Recruitment.Management.System.Services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/uploadResume")
    public ResponseEntity<Profile> uploadResume(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resumeService.uploadResume(file));
    }
}
