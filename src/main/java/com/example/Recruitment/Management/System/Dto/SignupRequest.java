package com.example.Recruitment.Management.System.Dto;

import com.example.Recruitment.Management.System.Entity.UserType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private String address;
    private String profileHeadline;
    private UserType userType; // ADMIN or APPLICANT
}
