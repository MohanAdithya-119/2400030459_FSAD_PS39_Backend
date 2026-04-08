package com.klu.studentportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists";
        }

        userRepository.save(user);

        return "Signup successful";
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        User existingUser = userRepository
                .findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return existingUser;
    }
}