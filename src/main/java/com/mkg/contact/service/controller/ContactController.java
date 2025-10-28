package com.mkg.contact.service.controller;

import com.mkg.contact.service.model.ContactSubmission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
@Tag(name = "Contact", description = "Contact form submission API")
public class ContactController {

    private final List<ContactSubmission> submissions = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    @Operation(summary = "Submit a contact form", description = "Submit a new contact form with name, email, subject, and message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contact form submitted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<ContactSubmission> submitContact(@RequestBody ContactSubmission submission) {
        submission.setId(idGenerator.getAndIncrement());
        submission.setSubmittedAt(LocalDateTime.now());
        submissions.add(submission);
        
        return ResponseEntity.ok(submission);
    }

    @GetMapping
    @Operation(summary = "Get all contact submissions", description = "Retrieve all submitted contact forms")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all contact submissions")
    public ResponseEntity<List<ContactSubmission>> getAllSubmissions() {
        return ResponseEntity.ok(new ArrayList<>(submissions));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get contact submission by ID", description = "Retrieve a specific contact submission by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved contact submission"),
            @ApiResponse(responseCode = "404", description = "Contact submission not found")
    })
    public ResponseEntity<ContactSubmission> getSubmission(
            @Parameter(description = "ID of the contact submission to retrieve") @PathVariable Long id) {
        return submissions.stream()
                .filter(submission -> submission.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Check if the contact service is running")
    @ApiResponse(responseCode = "200", description = "Service is healthy")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Contact service is running");
    }
}
