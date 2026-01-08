package com.example.demo.Controller;

import com.example.demo.security.*;
import java.util.Map;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> req) {

        if ("admin".equals(req.get("username"))
                && "admin123".equals(req.get("password"))) {

            String token = JwtUtil.generateToken("admin");
            return Map.of("token", token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
