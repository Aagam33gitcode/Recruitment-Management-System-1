package com.example.Recruitment.Management.System.Repositories;

import com.example.Recruitment.Management.System.Entity.Profile;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // Optionally find profile by user ID
    Profile findByUserId(Long userId);
}
