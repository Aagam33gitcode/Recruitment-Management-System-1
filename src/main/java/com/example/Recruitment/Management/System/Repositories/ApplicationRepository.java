package com.example.Recruitment.Management.System.Repositories;

import com.example.Recruitment.Management.System.Entity.Application;
import com.example.Recruitment.Management.System.Entity.Job;
import com.example.Recruitment.Management.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJob(Job job);
    List<Application> findByApplicant(User applicant);
}
