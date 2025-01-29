package com.myfinance.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    
    @Value("${password.encryption.salt}")
    private String salt;
    
    @Value("${password.encryption.strength}")
    private int strength;
    
    private final BCryptPasswordEncoder passwordEncoder;
    
    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder(strength);
    }
    
    public String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword + salt);
    }
    
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword + salt, encodedPassword);
    }
}