package com.example.searchjob.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    // Keywords
}
