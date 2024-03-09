package com.sai.samithi.contact;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ContactResponse {
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String subject;

    private String message;
    
    private Status status;
    
    private LocalDateTime createdDate;

}
