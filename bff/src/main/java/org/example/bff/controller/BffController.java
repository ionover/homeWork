package org.example.bff.controller;

import org.example.bff.model.UserProfile;
import org.example.bff.service.BffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    @Autowired
    private BffService bffService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long userId) {
        UserProfile userProfile = bffService.getUserProfile(userId);
        if (userProfile.getUser() != null) {
            return ResponseEntity.ok(userProfile);
        }
        return ResponseEntity.notFound().build();
    }
}