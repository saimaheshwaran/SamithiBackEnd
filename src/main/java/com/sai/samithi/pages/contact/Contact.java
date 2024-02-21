package com.sai.samithi.pages.contact;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;

@Data
@Builder
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String subject;

    private String message;
    
    private Status status; 

    @CreatedDate
    private LocalDateTime createdDate;
}
