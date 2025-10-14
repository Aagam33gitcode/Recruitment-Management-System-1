package com.example.Recruitment.Management.System.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String skills;
    private String education;
    private String experience;
    private String resumeFileAddress;
}
