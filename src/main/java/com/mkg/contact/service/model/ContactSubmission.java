package com.mkg.contact.service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Contact form submission")
public class ContactSubmission {
    @Schema(description = "Unique identifier for the contact submission", example = "1")
    private Long id;
    
    @Schema(description = "Name of the person submitting the contact form", example = "John Doe", required = true)
    private String name;
    
    @Schema(description = "Email address of the person submitting the contact form", example = "john.doe@example.com", required = true)
    private String email;
    
    @Schema(description = "Subject of the contact message", example = "Inquiry about your services", required = true)
    private String subject;
    
    @Schema(description = "The contact message content", example = "I would like to know more about your services.", required = true)
    private String message;
    
    @Schema(description = "Timestamp when the contact form was submitted", example = "2024-01-15T10:30:00")
    private LocalDateTime submittedAt;
}
