package com.example.erp.config;

import com.example.erp.entity.User;
import com.example.erp.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public DataSeeder(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) {
        seedUser("admin",      "admin@erp.com",      "admin@123",      "admin");
        seedUser("teacher",    "teacher@erp.com",    "teacher@123",    "teacher");
        seedUser("student",    "student@erp.com",    "student@123",    "student");
        seedUser("superadmin", "superadmin@erp.com", "superadmin@123", "superadmin");
    }

    private void seedUser(String username, String email, String password, String role) {
        if (userRepo.existsByUsername(username)) return;
        User u = new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(encoder.encode(password));
        u.setRole(role);
        userRepo.save(u);
        System.out.println("Seeded: " + username + " / " + password);
    }
}
