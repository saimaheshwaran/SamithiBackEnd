package com.sai.samithi.seva.schedule;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class SevaSchedule {

    @Id
    @SequenceGenerator(name="seva_schedule_seq_gen", sequenceName = "seva_schedule_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seva_schedule_seq_gen")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String schedule;

    @Column(nullable = false)
    private LocalDate publishedOn;

    @Column
    private LocalDateTime eventDateTime;
    
    @Column(nullable = false)
    private String details;

}

