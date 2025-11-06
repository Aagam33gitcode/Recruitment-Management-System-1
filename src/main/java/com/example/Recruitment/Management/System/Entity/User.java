package com.example.Recruitment.Management.System.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;

    private String address;
    private String profileHeadline;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType; // ADMIN or APPLICANT

    public enum UserType {
        ADMIN, APPLICANT
    }
}
