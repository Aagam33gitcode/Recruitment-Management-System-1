package com.example.Recruitment.Management.System.Dto;


import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime postedOn;
    private String companyName;
    private int totalApplications;
    private List<ApplicantInfo> applicants;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ApplicantInfo {
        private Long id;
        private String name;
        private String email;
    }
}
