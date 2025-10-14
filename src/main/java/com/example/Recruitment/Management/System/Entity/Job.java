package com.example.Recruitment.Management.System.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime postedOn;

    private int totalApplications;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User postedBy;

    @OneToMany(mappedBy = "job")
    private List<Application> applications;
}
