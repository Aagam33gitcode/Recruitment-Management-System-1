package com.example.Recruitment.Management.System.Services;

import com.example.Recruitment.Management.System.Entity.Job;
import com.example.Recruitment.Management.System.Repositories.JobRepository;
import com.example.Recruitment.Management.System.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    public Job createJob(Job job) {
        job.setPostedOn(LocalDateTime.now());
        return jobRepository.save(job);
    }

    public Job getJobWithApplicants(Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
