package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.entity.Insurer;
import com.example.demo.repository.InsurerRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InsurerRepository insurerRepo;

    @Autowired
    private WebClient webClient;

    // ===== INSURER (OWN DB) =====
    @PostMapping("/insurers")
    public Insurer createInsurer(@RequestBody Insurer insurer) {
        insurer.setStatus("ACTIVE");
        return insurerRepo.save(insurer);
    }

    // ===== MANIPULATE DATA SERVICE =====
    @PutMapping("/users/{id}/block")
    public String blockUser(
            @PathVariable Long id,
            HttpServletRequest request) {

        // ✅ Extract JWT from incoming request
        String authHeader = request.getHeader("Authorization");

        webClient.put()
            .uri("http://localhost:8088/data/internal/users/{id}/status?status=BLOCKED", id)
            .header("Authorization", authHeader) // ✅ FORWARD TOKEN
            .retrieve()
            .bodyToMono(Void.class)
            .block();

        return "User blocked successfully";
    }

    @PutMapping("/insurance/{id}/approve")
    public String approveInsurance(
            @PathVariable Long id,
            HttpServletRequest request) {

        // ✅ Extract JWT
        String authHeader = request.getHeader("Authorization");

        webClient.put()
            .uri("http://localhost:8088/data/internal/insurance/{id}/approve", id)
            .header("Authorization", authHeader) // ✅ FORWARD TOKEN
            .retrieve()
            .bodyToMono(Void.class)
            .block();

        return "Insurance approved successfully";
    }
}
