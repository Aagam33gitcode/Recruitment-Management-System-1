package com.example.Recruitment.Management.System.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumeFileAddress;

    private String skills;

    private String education;

    private String experience;

    private String phone;

    private String name;

    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
