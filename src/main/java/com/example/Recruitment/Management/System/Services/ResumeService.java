package com.example.Recruitment.Management.System.Services;

import com.example.Recruitment.Management.System.Entity.Profile;
import com.example.Recruitment.Management.System.Repositories.ProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service

public class ResumeService {



        @Autowired
        private ProfileRepository profileRepository;

        @Autowired
        private ModelMapper modelMapper;

        public Profile uploadResume(MultipartFile file) {
            // TODO: call 3rd-party resume parser
            // map JSON response to Profile entity
            Profile profile = new Profile();
            // example:
            // profile.setSkills("Java, Spring");
            return profileRepository.save(profile);
        }
    }

