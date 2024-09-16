package com.sai.samithi.youth.team;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class YouthTeam {

    @Id
    @SequenceGenerator(name="youth_team_seq_gen", sequenceName = "youth_team_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "youth_team_seq_gen")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private LocalDate publishedOn;
    
    @Column(nullable = false)
    private String details;

}

