package com.example.Recruitment.Management.System.Controller;


import com.example.Recruitment.Management.System.Entity.Job;
import com.example.Recruitment.Management.System.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    // Admin: create job
    @PostMapping("/admin/job")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.createJob(job));
    }

    // Admin: get job by ID with applicants
    @GetMapping("/admin/job/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        return ResponseEntity.ok(jobService.getJobWithApplicants(jobId));
    }

    // All users: get all jobs
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }
}
