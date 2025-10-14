package com.example.Recruitment.Management.System.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeUploadResponse {
    private String skills;
    private String education;
    private String experience;
    private String resumeFileAddress;
}
