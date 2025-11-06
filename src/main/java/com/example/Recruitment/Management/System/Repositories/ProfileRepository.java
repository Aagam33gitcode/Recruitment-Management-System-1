package com.example.Recruitment.Management.System.Repositories;

import com.example.Recruitment.Management.System.Entity.Profile;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);

}
