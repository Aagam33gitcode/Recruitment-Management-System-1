package com.example.Recruitment.Management.System.Repositories;

import com.example.Recruitment.Management.System.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // Add custom queries if needed
}
