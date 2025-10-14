package com.example.Recruitment.Management.System.Services;

import com.example.Recruitment.Management.System.Entity.Profile;
import com.example.Recruitment.Management.System.Entity.User;
import com.example.Recruitment.Management.System.Entity.UserType;
import com.example.Recruitment.Management.System.Repositories.ProfileRepository;
import com.example.Recruitment.Management.System.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<User> getAllApplicants() {
        return userRepository.findAll().stream()
                .filter(u -> u.getUserType() != null && u.getUserType().equals(UserType.APPLICANT))
                .collect(Collectors.toList());
    }

    public Profile getApplicantProfile(Long applicantId) {
        return profileRepository.findById(applicantId).orElse(null);
    }
}
