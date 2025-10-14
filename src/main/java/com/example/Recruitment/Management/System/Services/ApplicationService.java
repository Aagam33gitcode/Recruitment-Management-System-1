package com.example.Recruitment.Management.System.Services;

import com.example.Recruitment.Management.System.Entity.Application;
import com.example.Recruitment.Management.System.Entity.Job;
import com.example.Recruitment.Management.System.Entity.User;
import com.example.Recruitment.Management.System.Repositories.ApplicationRepository;
import com.example.Recruitment.Management.System.Repositories.JobRepository;
import com.example.Recruitment.Management.System.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    public void applyForJob(Long jobId, Long applicantId) {
        Job job = jobRepository.findById(jobId).orElseThrow();
        User applicant = userRepository.findById(applicantId).orElseThrow();

        Application application = new Application();
        application.setJob(job);
        application.setApplicant(applicant);
        application.setAppliedOn(LocalDateTime.now());

        applicationRepository.save(application);
        job.setTotalApplications(job.getTotalApplications() + 1);
        jobRepository.save(job);
    }
}
