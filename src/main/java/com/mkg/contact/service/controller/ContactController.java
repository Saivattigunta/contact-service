package com.mkg.contact.service.controller;

import com.mkg.contact.service.model.ContactSubmission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    private final List<ContactSubmission> submissions = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    public ResponseEntity<ContactSubmission> submitContact(@RequestBody ContactSubmission submission) {
        submission.setId(idGenerator.getAndIncrement());
        submission.setSubmittedAt(LocalDateTime.now());
        submissions.add(submission);
        
        return ResponseEntity.ok(submission);
    }

    @GetMapping
    public ResponseEntity<List<ContactSubmission>> getAllSubmissions() {
        return ResponseEntity.ok(new ArrayList<>(submissions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactSubmission> getSubmission(@PathVariable Long id) {
        return submissions.stream()
                .filter(submission -> submission.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Contact service is running");
    }
}
