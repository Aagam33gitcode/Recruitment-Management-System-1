package com.example.Recruitment.Management.System.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobRequest {
    private String title;
    private String description;
    private String companyName;
}
