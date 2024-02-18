package com.sai.samithi.pages.contact;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder @Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Contact {

    @Id
    @SequenceGenerator(name="contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactus_seq_gen")
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String subject;

    private String message;

}
