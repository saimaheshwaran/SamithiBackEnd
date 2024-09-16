package com.sai.samithi.home.posts;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Posts {

    @Id
    @SequenceGenerator(name="posts_seq_gen", sequenceName = "posts_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_seq_gen")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate publishedOn;

    @Column
    private LocalDateTime eventDateTime;
    
    @Column(nullable = false)
    private String url;

}

