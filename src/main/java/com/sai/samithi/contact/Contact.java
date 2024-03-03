package com.sai.samithi.contact;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Contact {

    @Id
    @SequenceGenerator(name="contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
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
