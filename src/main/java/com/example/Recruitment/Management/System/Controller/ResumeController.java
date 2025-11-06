package com.example.Recruitment.Management.System.Controller;

import com.example.Recruitment.Management.System.Entity.Profile;
import com.example.Recruitment.Management.System.Entity.User;
import com.example.Recruitment.Management.System.Repositories.ProfileRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResumeController {
    private final ProfileRepository profileRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${resume.api.key}")
    private String apiKey;
    @PostMapping("/uploadResume")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file,
                                          Authentication authentication) throws IOException {

        User user = (User) authentication.getPrincipal();
        if (user.getUserType() != User.UserType.APPLICANT) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Only applicants can upload resumes");
        }

        String filename = file.getOriginalFilename();
        if (filename == null || !(filename.endsWith(".pdf") || filename.endsWith(".docx"))) {
            return ResponseEntity.badRequest().body("Only PDF or DOCX files are allowed");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set("apikey", apiKey);

        HttpEntity<byte[]> entity = new HttpEntity<>(file.getBytes(), headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.apilayer.com/resume_parser/upload",
                HttpMethod.POST,
                entity,
                String.class
        );

        // Parse JSON response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.getBody());

        Profile profile = profileRepository.findByUserId(user.getId()).orElse(new Profile());

        profile.setUser(user);
        profile.setResumeFileAddress(filename);
        profile.setName(json.path("name").asText(null));
        profile.setEmail(json.path("email").asText(null));
        profile.setPhone(json.path("phone").asText(null));

        profile.setSkills(
                StreamSupport.stream(json.path("skills").spliterator(), false)
                        .map(JsonNode::asText)
                        .collect(Collectors.joining(", "))
        );

        profile.setEducation(
                StreamSupport.stream(json.path("education").spliterator(), false)
                        .map(e -> e.path("name").asText())
                        .collect(Collectors.joining(", "))
        );

        profile.setExperience(
                StreamSupport.stream(json.path("experience").spliterator(), false)
                        .map(e -> e.path("name").asText())
                        .collect(Collectors.joining(", "))
        );

        profileRepository.save(profile);

        return ResponseEntity.ok(profile);
    }

}
